import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] p, f;
    static long [] s;
    static int find(int x){
        return p[x] = p[x]==x? x : find(p[x]);
    }
    static void merge(int x, int y){
        if(find(x) == find(y)) return;
        s [find(x)] += s [find(y)];
        f [find(x)] += f [find(y)];
        p [find(y)] = p [find(x)];
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        p = new int [n+1]; s = new long [n+1]; f = new int [n+1];
        for(int i = 1; i <= n; i++){
            p [i] = i;
            s [i] = readInt();
            f [i] = 1;
        }
        for(int i = 0; i < q; i++){
            int c = readInt();
            if(c == 1){
                merge(readInt(), readInt());
            }
            else if(c == 2){
                System.out.println(f[find(readInt())]);
            }
            else if(c == 3){
                System.out.println(s[find(readInt())]);
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
            return -Integer.compare(x, p.x);
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