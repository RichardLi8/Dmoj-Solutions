import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        String s = readLine();
        int [] c = new int [m], p = new int [m];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0') p [cnt++] = i;
        }
        int max = 0, pos = 0;
        for(int i = 0; i < m; i++){
            c [i] = readInt();
            if(c [i] >= max){
                max = c [i];
                pos = p [i];
            }
        }
        for(int i = pos+1; i < n; i++){
            if(s.charAt(i) != '0') System.out.print(s.charAt(i));
        }
        for(int i = 0; i < pos; i++){
            if(s.charAt(i) != '0') System.out.print(s.charAt(i));
        }
        System.out.println();
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