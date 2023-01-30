import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(); Map <Integer, Integer> map = new HashMap(); int max = 0, ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int a = readInt();
            map.put(a, map.getOrDefault(a, 0) + 1);
            if(max < map.get(a)){
                max = map.get(a);
                ans = a;
            }
            else if(map.get(a) == max){
                ans = Math.min(ans, a);
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
            return -Integer.compare(x, p.x);
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