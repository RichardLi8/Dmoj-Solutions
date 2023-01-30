import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int t = readInt(), f = readInt(), n = readInt();
        int [][] dp = new int [t+1][f+1];
        for(int q = 0; q < n; q++){
            int v = readInt(), time = readInt(), food = readInt();
            for(int i = t; i >= time; i--){
                for(int j = f; j >= food; j--){
                    dp [i][j] = Math.max(dp [i][j], dp [i-time][j-food]+v);
                }
            }
        }
        System.out.println(dp [t][f]);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Integer.compare(y, p.y);
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
}