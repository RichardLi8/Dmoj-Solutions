import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] bit;
    static void update(int i, int v){
        for(; i < bit.length; i += i&-i){
            bit [i] = Math.max(bit [i], v);
        }
    }
    static int query(int i){
        int ret = 0;
        for(; i > 0; i -= i&-i){
            ret = Math.max(ret, bit [i]);
        }
        return ret;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), cnt = 1;
        Map <Integer, Integer> map = new HashMap();
        TreeSet <Integer> set = new TreeSet();
        pair [] a = new pair [n+1];
        for(int i = 1; i <= n; i++){
            int x = readInt(), y = readInt();
            set.add(x-y); set.add(x+y); set.add(x);
            a [i] = new pair(x, y);
        }
        for(int v : set){
            if(map.containsKey(v)) continue;
            map.put(v, cnt++);
        }
        bit = new int [set.size()]; int [] dp = new int [n+1];
        Arrays.sort(a, 1, n+1);
        PriorityQueue <pair> pq = new PriorityQueue();
        int ans = 0;
        for(int i = 1; i <= n; i++){
            while(!pq.isEmpty() && pq.peek().x <= map.get(a [i].x)){
                update(map.get(a [pq.peek().y].x), dp [pq.poll().y]);
            }
            int cur = query(map.get(a [i].x-a [i].y));
            dp [i] = cur+1;
            ans = Math.max(ans, cur+1);
            pq.add(new pair(map.get(a [i].x + a [i].y), i));
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine();
    }
}