import java.io.*;
import java.util.*;
public class HelloWorld {
    static void recover(int c, int r){
        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                d [i][j] += d [i][j-1] + d [i-1][j] - d [i-1][j-1];
            }
        }
    }
    static int dr [] = {1, -1, 0, 0}, dc [] = {0, 0, 1, -1};
    static long [][] len, sum, d;
    static int mod = 1000000007;
    static void dfs(int x, int y){
        sum [x][y] = d [x][y];
        for(int i = 0; i < 4; i++){
            int newx = x + dr [i], newy = y + dc [i];
            if(d [newx][newy] > d [x][y]){
                if(sum [newx][newy] == 0){
                    dfs(newx, newy);
                }
                if(len [x][y] < len [newx][newy] + 1){
                    len [x][y] = len [newx][newy] + 1;
                    sum [x][y] = sum [newx][newy] + d [x][y];
                }
                else if(len [x][y] == len [newx][newy] + 1){
                    sum [x][y] = Math.max(sum [x][y], sum [newx][newy] + d [x][y]);
                }
            }
        }
    }
    public static void main(String [] args) throws IOException{
        int c = readInt(), r = readInt(), m = readInt();
        d = new long [r+3][c+3];
        for(int i = 0; i < m; i++){
            int y = readInt(), x = readInt(), w = readInt(), h = readInt(), n = readInt();
            d [x][y] += n; d [x+h][y] -= n; d [x][y+w] -=n; d [x+h][y+w] += n;
            d [x][y+w] -= w*n; d [x][y+w+1] += w*n; d [x+h][y+w] += w*n; d [x+h][y+w+1] -= w*n;
            d [x+h][y] -= h*n; d [x+h+1][y] += h*n; d [x+h][y+w] += h*n; d [x+h+1][y+w] -= h*n;
            d [x+h][y+w] += w*h*n; d [x+h+1][y+w] -= w*h*n; d [x+h][y+w+1] -= w*h*n; d [x+h+1][y+w+1] += w*h*n;
        }
        recover(c,r); recover(c,r);
        int y = readInt(), x = readInt();
        sum = new long [r+2][c+2]; len = new long [r+2][c+2];
        dfs(x, y);
        System.out.println(sum [x][y]%mod);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) { 
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
}