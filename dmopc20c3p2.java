import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int m = readInt(), n = readInt(), k = readInt();
        int [][] g = new int [m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                g [i][j] = readInt();
            }
        }
        int ans = 0;
        HashMap <Integer, Integer> pre = new HashMap();
        for(int j = 0; j < n-1; j++){
            pre.clear();
            for(int i = 0; i < m; i++){
                if(pre.containsKey(g [i][j]-k) && pre.get(g [i][j]-k) == g [i][j+1]-k) ans++;
                if(pre.containsKey(g [i][j]+k) && pre.get(g [i][j]+k) == g [i][j+1]+k) ans++;
                pre.put(g [i][j], g [i][j+1]);
            }
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