import java.io.*;
import java.util.*;
public class HelloWorld {
    static int bit [];
    static void update(int i, int v){
        for(; i < bit.length; i += i&-i){
            bit [i] += v;
        }
    }
    static int query(int i){
        int sum = 0;
        for(; i > 0; i -= i&-i){
            sum += bit [i];
        }
        return sum;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        List <Integer> [] due = new List [n+1];
        for(int i = 1; i <= n; i++) due [i] = new ArrayList();
        for(int i = 1; i <= n; i++){
            int d = readInt();
            due [d].add(i);
        }
        PriorityQueue <Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int [] order = new int [n+1];
        for(int i = n; i >= 1; i--){
            for(int v: due [i]){
                pq.add(v);
            }
            if(pq.isEmpty()){
                System.out.println(-1);
                return;
            }
            order [i] = pq.poll();
        }
        bit = new int [n+1];
        long ans = 0;
        for(int i = n; i >= 1; i--){
            ans += query(order [i]-1);
            update(order [i], 1);
        }
        System.out.println(ans);
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