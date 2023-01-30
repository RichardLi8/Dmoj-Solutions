import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), a = 0, b = 0;
        for(int i = 0; i < n; i++){
            int p = readInt();
            if(p > 100) continue;
            if(a < p){
                b = a;
                a = p;  
            }
            else if(b < p){
                b = p;
            }
        }
        System.out.println(a+b);
    }
    static class triple implements Comparable <triple>{
        String s; int x, y;
        triple(String a, int b, int c){
            s = a;
            x = b;
            y = c;
        }
        public int compareTo(triple t){
            return s.compareTo(t.s);
        }
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