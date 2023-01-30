import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int grid [][] = new int [n+2][n+2];
        ArrayList <triple> arr = new ArrayList();
        int dp [][] = new int [n+2][n+2];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                grid [i][j] = readInt();
                arr.add(new triple(grid [i][j], i, j));
            }
        }
        int dr [] = {1, -1, 0, 0}, dc [] = {0, 0, 1, -1};
        int ans = 0;
        Collections.sort(arr);
        for(int j = 0; j < n*n; j++){
            triple t = arr.get(j);
            int x = t.x, y = t.y;
            for(int i = 0; i < 4; i++){
                if(grid [x+dr[i]][y+dc[i]] > grid [x][y]){
                    dp [x][y] = Math.max(dp [x][y], dp [x+dr[i]][y+dc[i]] + 1);
                }
            }
            ans = Math.max(dp [x][y], ans);
        }
        System.out.println(ans);
    }
    static class triple implements Comparable <triple>{
        int v, x, y;
        public triple(int a, int b, int c){
            v = a;
            x = b;
            y = c;
        }
        public int compareTo(triple t){
            return -Integer.compare(v, t.v);
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
}