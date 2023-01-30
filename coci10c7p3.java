import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), p = readInt(), ans = 0;
        Deque <Integer> stk [] = new LinkedList [7];
        for(int i = 1; i <= 6; i++) stk [i] = new LinkedList();
        for(int i = 0; i < n; i++){
            int s = readInt(), f = readInt();
            while(!stk [s].isEmpty() && stk [s].peekLast() > f){
                stk [s].pollLast();
                ans++;
            }
            if(stk [s].isEmpty() || stk [s].peekLast() != f){
                stk [s].addLast(f);
                ans++;
            }
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int f, s;
        pair(int a, int b){
            f = a;
            s = b;
        }
        public int compareTo(pair p){
            return Long.compare(s, p.s);
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