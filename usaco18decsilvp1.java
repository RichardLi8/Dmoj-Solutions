import java.io.*;
import java.util.*;
public class HelloWorld {
    static int n, m, c, a [];
    static boolean check(int gap){
        int bus = 1, cnt = 1, st = a [0];
        for(int i = 1; i < n; i++){
            if(cnt == c || a [i]-st > gap){
                bus++;
                cnt = 1;
                st = a [i];
            }
            else cnt++;
        }
        return bus <= m;
    }
    public static void main(String [] args) throws IOException{
        n = readInt(); m = readInt(); c = readInt();
        a = new int [n];
        for(int i = 0; i < n; i++) a [i] = readInt();
        Arrays.sort(a);
        int l = 0, r = (int)1e9;
        while(l <= r){
            int mid = (l+r)>>1;
            if(check(mid)){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        System.out.println(l);
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