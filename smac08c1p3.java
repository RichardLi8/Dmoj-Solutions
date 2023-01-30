import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt();
        int [] a = new int [n+1];
        for(int i = 1; i <= n; i++) a [i] = readInt();
        Deque <pair> dq = new LinkedList();
        dq.addLast(new pair(a [1], 1));
        for(int i = 2; i <= n; i++){
            int v = a [i] + dq.peekFirst().v;
            if(!dq.isEmpty() && dq.peekFirst().i <= i-k) dq.pollFirst();
            while(!dq.isEmpty() && dq.peekLast().v >= v) dq.pollLast();
            dq.addLast(new pair(v, i));
        }
        System.out.println(dq.peekLast().v);
    }
    static class pair{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
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