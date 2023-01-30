import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt();
        int pos = 0; char [] a = new char [n]; boolean [] vis = new boolean [26];
        for(int i = 0; i < k; i++){
            pos -= readInt();
            pos = (pos%n+n)%n;
            char c = next().charAt(0);
            if((vis [c-'A'] && a [pos] != c) || (a [pos] != 0 && a [pos] != c)){
                System.out.println("!");
                return;
            }
            a [pos] = c; vis [c-'A'] = true;
        }
        for(int i = 0; i < n; i++){
            System.out.print(a [pos] != 0? a [pos] : '?');
            pos = (pos+1)%n;
        }
        System.out.println();
    }
    static class pair implements Comparable <pair>{
        int f, s;
        pair(int a, int b){
            f = a;
            s = b;
        }
        public int compareTo(pair p){
            return Long.compare(s, p.s);
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