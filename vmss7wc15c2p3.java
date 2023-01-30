import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        long [] hills = new long [n];
        for(int i = 0; i < n; i++) hills [i] = readLong();
        Deque <pair> stk = new LinkedList();
        long ans = 0;
        for(int i = n-1; i >= 0; i--){
            while(!stk.isEmpty() && stk.peekLast().v < hills [i]){
                ans += stk.pollLast().c;
            }
            if(!stk.isEmpty() && stk.peekLast().v == hills [i]){
                long c = stk.pollLast().c;
                ans += c;
                if(!stk.isEmpty()) ans++;
                stk.addLast(new pair(hills [i], c+1));
            }
            else{
                if(!stk.isEmpty()) ans++;
                stk.addLast(new pair(hills [i], 1));
            }
        }
        System.out.println(ans);
    }
    static class pair{
        long v, c;
        pair(long a, long b){
            v = a;
            c = b;
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