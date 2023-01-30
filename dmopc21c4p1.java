import java.io.*;
import java.util.*;
public class HelloWorld {
    static long area(pair a, pair b, pair c){
        return Math.abs(a.x*(b.y-c.y) + b.x*(c.y-a.y) + c.x*(a.y-b.y));
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        tree [] a = new tree [n];
        for(int i = 0; i < n; i++){
            a [i] = new tree(new pair(readInt(), readInt()), new pair(readInt(), readInt()), new pair(readInt(), readInt()));
        }
        for(int k = 0; k < q; k++){
            pair c = new pair(readInt(), readInt());
            int ans = 0;
            for(int i = 0; i < n; i++){
                if(area(a [i].a, a [i].b, c) + area(a [i].a, c, a [i].c) + area(c, a [i].b, a [i].c) == a [i].area) ans++;
            }
            System.out.println(ans);
        }
    }
    static class tree{
        long area;
        pair a, b, c;
        tree(pair a, pair b, pair c){
            this.a = a;
            this.b = b;
            this.c = c;
            area = area(a, b, c);
        }
    }
    static class pair implements Comparable <pair>{
        long x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Long.compare(y, p.y);
            return Long.compare(x, p.x);
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