import java.io.*;
import java.util.*;
public class HelloWorld {
    static int query(int r, int c){
        int sum = 0;
        for(int i = r; i > 0; i -= (i&-i)){
            for(int j = c; j > 0; j -= (j&-j)){
                sum += bit [i][j];
            }
        }
        return sum;
    }
    static void update(int r, int c, int v){
        for(int i = r; i < bit.length; i += (i&-i)){
            for(int j = c; j < bit [0].length; j += (j&-j)){
                bit [i][j] += v;
            }
        }
    }
    static int [][] bit;
    public static void main(String [] args) throws IOException{
        readInt(); int n = readInt();
        bit = new int [n+1][n+1];
        int c;
        while((c = readInt()) != 3){
            if(c == 1){
                int x = readInt()+1, y = readInt()+1, a = readInt();
                update(x, y, a);
            }
            else{
                int l = readInt()+1, b = readInt()+1, r = readInt()+1, t = readInt()+1;
                System.out.println(query(r, t)-query(r, b-1)-query(l-1, t)+query(l-1, b-1));
            }
        }
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            if(w == p.w) return -Integer.compare(v, p.v);
            return -Integer.compare(w, p.w);
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