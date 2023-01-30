import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        pair [] intervals = new pair [n];
        for(int i = 0; i < n; i++){
            intervals [i] = new pair(readInt(), readInt());
        }
        Arrays.sort(intervals);
        int ans = 1;
        for(int i = 1; i < n; i++){
            if(intervals [i-1].f <= intervals [i].s){
                ans++;
            }
            else{
                intervals [i].f = intervals [i-1].f;
            }
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int s, f;
        pair(int a, int b){
            s = a;
            f = b;
        }
        public int compareTo(pair p){
            return Integer.compare(f, p.f);
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