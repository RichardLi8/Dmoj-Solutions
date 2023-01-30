import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String[] args) throws IOException{
        int n = readInt();
        String [] a = new String [n];
        boolean [] b = new boolean [n], nxt = new boolean [n];
        for(int i = 0; i < n; i++){
            a [i] = readLine();
            if(a [i].contains("yubo")){
                b [i] = true;
            }
        }
        for(int i = 1; i < n; i++){
            if(b [i-1]) nxt [i] = true;
        }
        for(int i = n-2; i >= 0; i--){
            if(b [i+1]) nxt [i] = true;
        }
        TreeSet <String> set = new TreeSet();
        for(int i = 0; i < n; i++){
            if(b [i] || nxt [i]) set.add(a [i]);
        }
        for(String s : set){
            System.out.println(s);
        }
    }
    static class cmp implements Comparator <Integer>{
        public int compare(Integer a, Integer b){
            return 0;
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