import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        for(int q = 0; q < 10; q++){
            int n = readInt();
            List <Double> tasks [] = new ArrayList [1000001];
            for(int i = 1; i <= 1000000; i++) tasks [i] = new ArrayList();
            for(int i = 0; i < n; i++){
                tasks [readInt()].add(readDouble());
            }
            PriorityQueue <Double> pq = new PriorityQueue(Collections.reverseOrder());
            double ans = 0;
            for(int i = 1000000; i >= 1; i--){
                for(double d : tasks [i]){
                    pq.add(d);
                }
                if(pq.isEmpty()) continue;
                ans += pq.poll();
            }
            System.out.printf("%.4f\n", ans);
        }
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