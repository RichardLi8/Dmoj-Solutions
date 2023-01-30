import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), x = readInt();
        long [][] pre = new long [2501][51];
        pre [0][0] = 1;
        long ans = 0;
        for(int i = 0; i < n; i++){
            int a = readInt();
            for(int j = 50; j >= 1; j--){
                for(int k = 2500; k >= a; k--){
                    pre [k][j] += pre [k-a][j-1];
                }
            }
        }
        for(int i = 1; i <= 50; i++){
            ans += pre [i*x][i];
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(y == p.y) return Integer.compare(x, p.x);
            return -Integer.compare(y, p.y);
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