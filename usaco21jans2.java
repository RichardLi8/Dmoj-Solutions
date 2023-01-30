import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        int [] a = new int [n+1]; String s = br.readLine();
        for(int i = 1; i <= n; i++){
            a [i] = s.charAt(i-1)-'A';
        }
        Deque <Integer> stk = new LinkedList();
        int [] l = new int [n+1]; int cnt = 0;
        for(int i = 1; i <= n; i++){
            while(!stk.isEmpty() && stk.peekLast() > a [i]){
                stk.pollLast();
            }
            if(stk.isEmpty() || stk.peekLast() != a [i]) cnt++;
            stk.addLast(a [i]);
            l [i] = cnt;
        }
        stk = new LinkedList();
        int r [] = new int [n+2]; cnt = 0;
        for(int i = n; i >= 1; i--){
            while(!stk.isEmpty() && stk.peekLast() > a [i]){
                stk.pollLast();
            }
            if(stk.isEmpty() || stk.peekLast() != a [i]) cnt++;
            stk.addLast(a [i]);
            r [i] = cnt;
        }
        for(int i = 0; i < q; i++){
            int x = readInt(), y = readInt();
            System.out.println(l [x-1] + r [y+1]);
        }
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return Long.compare(v, p.v);
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