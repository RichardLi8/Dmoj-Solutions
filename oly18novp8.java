import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] bit;
    static void update(int i, int v){
        for(; i < bit.length; i += i&-i){
            bit [i] += v;
        }
    }
    static int query(int i){
        int ret = 0;
        for(; i > 0; i -= i&-i){
            ret += bit [i];
        }
        return ret;
    }
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int [] lvl = new int [n];
        bit = new int [32002];
        for(int i = 0; i < n; i++){
            int x = readInt()+1, y = readInt()+1;
            lvl [query(x)]++;
            update(x, 1);
        }
        for(int i = 0; i < n; i++){
            pr.write(lvl [i] + "\n");
        }
        pr.close();
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