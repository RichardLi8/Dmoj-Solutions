import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        long n = readLong();
        long bound = (long) Math.sqrt(n);
        ArrayList <Long> arr = new ArrayList();
        for(long i = 1; i <= bound; i++){
            if(i*i == n) arr.add(bound);
            else if(n%i==0){
                arr.add(i);
                arr.add(n/i);
            }
        }
        Collections.sort(arr);
        for(long v : arr){
            System.out.println(v);
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