import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
       int n = readInt(), k = readInt();
       int [] rows = new int [n];
       for(int i = 0; i < n; i++){
           String [] s = br.readLine().split(" ");
           int bit = 1;
           for(int j = k-1; j >= 0; j--){
               if(s [j].equals("1")){
                   rows [i] |= bit;
               }
               bit <<= 1;
           }
       }
       Set <Integer> prev = new HashSet();
       prev.add(rows [0]);
       for(int i = 1; i < n; i++){
           Set <Integer> cur = new HashSet();
           cur.add(rows [i]);
           for(Integer v : prev){
               cur.add(rows [i] ^ v);
           }
           prev = cur;
       }
        System.out.println(prev.size());
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