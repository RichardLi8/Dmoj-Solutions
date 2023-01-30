import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String[] args) throws IOException{
        int n = readInt();
        String s = readLine();
        boolean found = false;
        for(int i = 0; i < n; i++){
            if(i != n-1 && !found && s.charAt(i) < s.charAt(i+1)){
                System.out.print(s.charAt(i+1) + "" + s.charAt(i));
                i = i+1;
                found = true;
                continue;
            }
            System.out.print(s.charAt(i));
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
            if(v == p.v) return Integer.compare(w, p.w);
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}