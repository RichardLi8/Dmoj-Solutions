import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt();
        long [] heat = new long [n+2];
        int [] pre = new int [n+2];
        for(int i = 1; i <= n; i++){
            int c = 0;
            while((c = br.read()) != ' ' && c != '\n'){
                heat [i] = heat [i] * 10 + (c-'0');
            }
        }
        Deque <pair> dq = new LinkedList();
        dq.addLast(new pair(0, 0));
        for(int i = 1; i <= n; i++){
            long v = heat [i] + dq.peekFirst().v;
            pre [i] = dq.peekFirst().i;
            while(!dq.isEmpty() && dq.peekLast().v >= v) dq.pollLast();
            if(!dq.isEmpty() && dq.peekFirst().i <= i-k) dq.pollFirst();
            dq.addLast(new pair(v, i));
        }
        System.out.println(dq.peekFirst().v);
        ArrayList <Integer> out = new ArrayList();
        for(int x = dq.peekFirst().i; x != 0; x = pre[x]){
            out.add(x);
        }
        for(int i = out.size()-1; i >= 0; i--){
            System.out.print(out.get(i) + " ");
        }
        System.out.println();
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