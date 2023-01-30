import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(); long t = readLong();
        int [] a = new int [n]; String s = br.readLine();
        for(int i = 0; i < n; i++){
            a [i] = s.charAt(i)-'0';
        }
        for(int i = 0; i < 62; i++){
            if((t&1l << i) == 0) continue;
            int shift = (int) ((1l << i)%n);
            int temp [] = new int [n];
            for(int j = 0; j < n; j++){
                temp [j] = a [((j-shift)%n+n)%n] ^ a [(j+shift)%n];
            }
            a = temp;
        }
        for(int i = 0; i < n; i++){
            System.out.print(a [i]);
        }
        System.out.println();
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            return Integer.compare(w, p.w);
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