import java.io.*;
import java.util.*;
public class HelloWorld {
    static int bit [];
    static void update(int i, int v){
        for(; i < bit.length; i+=i&-i){
            bit [i] = Math.max(bit [i], v);
        }
    }
    static int query(int i){
        int ret = 0;
        for(; i > 0; i-=i&-i){
            ret = Math.max(bit [i], ret);
        }
        return ret;
    }
    public static void main(String [] args) throws IOException{
        int q = readInt(), p = readInt(), n = (int)2e5, pre = 0;
        bit = new int [(int)4e5+5];
        for(int i = 0; i < q; i++){
            char c = readChar();
            if(c == 'A'){
                update(n, readInt()^pre);
                n--;
            }
            else{
                int k = readInt()^pre;
                pre = query(n+k);
                System.out.println(pre);
            }
        }
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
        return br.readLine();
    }
}