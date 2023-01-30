import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static int dfs(int x, int y){
        if(vis [x][y]) return 0;
        vis [x][y] = true;
        int cnt = 1;
        for(int i = 0; i < 4; i++){
            int nx = x + dx [i], ny = y + dy [i];
            if(g [nx][ny] == g [x][y]){
                cnt += dfs(nx, ny);
            }
        }
        return cnt;
    }
    static void prune(int x, int y){
        empty [y] = Math.max(empty [y], x);
        int v = g [x][y]; g [x][y] = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx [i], ny = y + dy [i];
            if(g [nx][ny] == v){
                prune(nx, ny);
            }
        }
        
    }
    static void gravity(){
        for(int j = 1; j <= 10; j++){
            for(int i = empty [j]; i >= 1; i--){
                if(g [i][j] == 0) continue;
                g [empty [j]][j] = g [i][j];
                g [i][j] = 0; 
                empty [j]--;
            }
        }
    }
    static int [][] g;
    static int n;
    static int [] empty;
    static boolean [][] vis;
    public static void main(String [] args) throws IOException{
        n = readInt(); int k = readInt();
        g = new int [n+2][12]; empty = new int [12];
        for(int i = 1; i <= n; i++){
            String s = readLine();
            for(int j = 1; j <= 10; j++){
                g [i][j] = s.charAt(j-1)-'0';
                if(g [i][j] == 0) empty [j] = i;
            }
        }
        boolean flag = true;
        while(flag){
            flag = false;
            vis = new boolean [n+2][12];
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= 10; j++){
                    int cnt = 0;
                    if(g [i][j] != 0){
                        cnt = dfs(i, j);
                    }
                    if(cnt >= k){
                        prune(i, j);
                        flag = true;
                    }
                }
            }
            gravity();
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 10; j++){
                System.out.print(g [i][j]);
            }
            System.out.println();
        }
    }
    static class cow{
        int p, t, s;
        cow(int a, int b, int c){
            p = a;
            t = b;
            s = c;
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return Integer.compare(x, p.x);
        }
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine();
    }
}