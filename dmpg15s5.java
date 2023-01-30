import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        short [][] grid = new short [n+2][n+2];
        for(int i = 0; i < m; i++){
            int x = readInt()+1, y = readInt()+1, w = readInt()-1, h = readInt()-1;
            grid [x][y] += 1;
            grid [x+w+1][y]-=1;
            grid [x][y+h+1]-=1;
            grid [x+w+1][y+h+1]+=1;
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                grid [i][j] += grid [i-1][j] + grid [i][j-1] - grid [i-1][j-1];
                if((grid [i][j] & 1) == 1) ans++;
            }
        }
        System.out.println(ans);
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