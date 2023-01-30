import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        cow [] a = new cow [n];
        for(int i = 0; i < n; i++){
            a [i] = new cow(readInt(), readInt(), i);
        }
        Arrays.sort(a, (x, y) -> Integer.compare(x.p, y.p));
        PriorityQueue <cow> pq = new PriorityQueue <>((x, y) -> Integer.compare(x.s, y.s));
        int time = 1, ans = 0;
        for(int i = 0; i < n;){
            if(time <= a [i].p && pq.isEmpty()){
                time = a [i].p + a [i].t;
                i++;
            }
            else{
                while(i < n && a [i].p < time){
                    pq.add(a [i]);
                    i++;
                }
                ans = Math.max(ans, time-pq.peek().p);
                time += pq.poll().t;
            }
        }
        System.out.println(ans);
    }
    static class cow{
        int p, t, s;
        cow(int a, int b, int c){
            p = a;
            t = b;
            s = c;
        }
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