import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt();
        long [] a = new long [n*2+1], psa = new long [n*2+1];
        for(int i = 1; i <= n; i++){
            a [i] = a [n+i] = readInt();
        }
        for(int i = 1; i <= n*2; i++){
            psa [i] += psa [i-1] + a [i];
        }
        Deque <pair> dq = new LinkedList();
        long ans = Long.MIN_VALUE;
        for(int i = 1; i <= n*2; i++){
            if(!dq.isEmpty() && dq.peekFirst().i <= i-k) dq.pollFirst();
            while(!dq.isEmpty() && dq.peekLast().v >= psa [i-1]) dq.pollLast();
            dq.add(new pair(psa [i-1], i));
            ans = Math.max(ans, psa [i]-dq.peekFirst().v);
        }
        System.out.println(ans);
    }
    static class pair{
        long v; int i;
        pair(long a, int b){
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