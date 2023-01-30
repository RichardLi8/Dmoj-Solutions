import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int c = readInt(), n = readInt();
        int [] a = new int [n];
        for(int i = 0; i < n; i++){
            a [i] = readInt();
        }
        boolean [] used = new boolean [c+1];
        Deque <Integer> out = new LinkedList();
        for(int i = n-1; i >= 0; i--){
            if(!used [a [i]]){
                out.addLast(a [i]);
                used [a [i]] = true;
            }
        }
        System.out.println(out.size());
        while(!out.isEmpty()){
            System.out.print(out.pollLast() + " ");
        }
        System.out.println();
    }
    static class pair implements Comparable <pair>{
        long v, w;
        pair(long a, long b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            return Long.compare(w, p.w);
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