import java.io.*;
import java.util.*;
public class HelloWorld {
    static int m = 1;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        Integer [] a = new Integer [n];
        int time = 0;
        for(int i = 0; i < n; i++){
            a [i] = readInt();
            time = Math.max(time, (int) Math.log10(a [i])+1);
        }
        for(int i = 0; i < time; i++){
            m *= 10;
            Arrays.sort(a, new cmp());
            for(int j = 0; j < n; j++){
                System.out.print(a [j] + (j != n-1? " " : "\n"));
            }
        }
    }
    static class cmp implements Comparator <Integer>{
        public int compare(Integer a, Integer b){
            return Integer.compare(a%m, b%m);
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x != p.x) return Integer.compare(x, p.x);
            return Integer.compare(y, p.y);
        }
    }
    static PrintWriter pr = new PrintWriter(System.out);
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