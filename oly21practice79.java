import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        HashMap <Integer, Integer> map = new HashMap();
        for(int i = 0; i < n; i++){
            int a = readInt();
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        int max = 0, ans = Integer.MAX_VALUE;
        for(int v : map.keySet()){
            if(map.get(v) > max){
                max = map.get(v);
                ans = v;
            }
            else if(map.get(v) == max){
                ans = Math.min(ans, v);
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