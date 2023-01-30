import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int a [] = new int [n];
        Deque <pair> stk = new LinkedList();
        for(int i = 0; i < n; i++){
            a [i] = readInt();
        }
        long ans = 0;
        for(int i = n-1; i >= 0; i--){
            while(!stk.isEmpty() && stk.peekLast().v < a [i]){
                ans += stk.removeLast().c;
            }
            pair p = new pair(a [i], 1);
            if(!stk.isEmpty() && stk.peekLast().v == a [i]){
                p = stk.removeLast();
                ans += p.c;
                p.c++;
            }
            if(!stk.isEmpty()) {
                if(a [i] < stk.peekLast().v) ans++;
            }
            stk.addLast(p);
        }
        System.out.println(ans);
    }
    static class pair{
        int v, c;
        pair(int a, int b){
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