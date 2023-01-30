import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        pair [] weights = new pair [n*2];
        for(int i = 0; i < 2*n; i++){
            weights [i] = new pair(i+1, readInt());
        }
        Arrays.sort(weights);
        int m = 0;
        ArrayList <pair> out = new ArrayList();
        for(int i = 0; i < n; i++){
            if(weights [i].y != weights [i+n].y) m++;
            out.add(new pair(weights [i].x, weights [i+n].x));
        }
        System.out.println(m);
        for(pair p : out){
            System.out.println(p.x + " " + p.y);
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return Integer.compare(y, p.y);
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