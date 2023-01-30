import java.io.*;
import java.util.*;
public class HelloWorld {
    static long combos(long x){
        return x*(x+1)/2;
    }
    static void print(int f, int s){
        System.out.println(f+s+1);
        for(int i = 0; i < f; i++){
            System.out.print(0 + " ");
        }
        System.out.print(1);
        for(int i = 0; i < s; i++){
            System.out.print(" " + 0);
        }
        System.out.println();
        System.exit(0);
    }
    public static void main(String [] args) throws IOException{
        long k = readLong();
        if(k == combos(1000000)){
            System.out.println(1000000);
            for(int i = 1; i < 1000000; i++) System.out.print(0 + " ");
            System.out.println(0);
            return;
        }
        Map <Long, Integer> map = new HashMap();
        for(int i = 1000000; i >= 0; i--){
            map.put(combos(i), i);
        }
        for(int i = 1000000; i >= 0; i--){
            long cnt = combos(i);
            if(cnt > k) continue;
            if(map.containsKey(k-cnt)){
                int j = map.get(k-cnt);
                if(i + j + 1 > 1000000) continue;
                print(i, j);
            }
        }
        System.out.println(-1);
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}