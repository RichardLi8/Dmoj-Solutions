import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), h [] = new int [n], ans [] = new int [n];
        for(int i = 0; i < n; i++){
            h [i] = readInt();
        }
        Deque <pair> stk = new LinkedList();
        for(int i = n-1; i >= 0; i--){
            while(!stk.isEmpty() && stk.peekLast().v < h [i]){
                ans [stk.peekLast().i] = stk.pollLast().i-i;
            }
            stk.addLast(new pair(h [i], i));
        }
        while(!stk.isEmpty()){
            ans [stk.peekLast().i] = stk.pollLast().i;
        }
        for(int v : ans){
            System.out.print(v + " ");
        }
        System.out.println();
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return Integer.compare(i, p.i);
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