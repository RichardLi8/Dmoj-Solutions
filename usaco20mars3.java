import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        pair [] a = new pair [n];
        for(int i = 0; i < n; i++){
            a [i] = new pair(readInt(), readInt());
        }
        Arrays.sort(a);
        Deque <Integer> stk = new LinkedList();
        for(int i = n-1; i >= 0; i--){
            int max = a [i].y;
            while(!stk.isEmpty() && stk.peekLast() >= a [i].y){
                max = Math.max(max, stk.pollLast());
            }
            stk.addLast(max);
        }
        System.out.println(stk.size());
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Integer.compare(y, p.y);
            return Integer.compare(x, p.x);
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