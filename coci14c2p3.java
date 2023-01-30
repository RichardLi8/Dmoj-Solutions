import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt();
        int [] a = new int [n+1], sorted = new int [n+1];
        for(int i = 1; i <= n; i++){
            sorted [i] = a [i] = readInt();
        }
        Map <Integer, Integer> idx = new HashMap();
        Arrays.sort(sorted, 1, n+1);
        for(int i = 1; i <= n; i++){
            idx.put(sorted [i], (i-1)/k);
        }
        int [] dp = new int [n+1];
        int ans = 0;
        for(int i = 1; i <= n; i++){
            dp [i] = 1;
            for(int j = 1; j < i; j++){
                if(idx.get(a [i]) >= idx.get(a [j])) dp [i] = Math.max(dp [i], dp [j] + 1);
            }
            ans = Math.max(dp [i], ans);
        }
        System.out.println(n-ans);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(y != p.y) return -Integer.compare(y, p.y);
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