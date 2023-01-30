import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        boolean [] out = new boolean [32];
        String [] a = new String [n];
        for(int i = 0; i < n; i++){
            a [i] = br.readLine();
        }
        String want = br.readLine();
        for(int i = 0; i < n; i++){
            if(a [i].length() > want.length() && a [i].startsWith(want)){
                out [a[i].charAt(want.length())-'A'+3] = true;
            }
        }
        for(int i = 0; i < 32; i++){
            if(i != 0 && i % 8 == 0) System.out.println();
            System.out.print(out [i]? (char)(i+'A'-3) : '*');
        }
        System.out.println();
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
}