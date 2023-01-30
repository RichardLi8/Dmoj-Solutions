import java.io.*;
import java.util.*;
public class HelloWorld {
    static int find(long v, long [] dist){
        int l = 0, r = dist.length-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(dist [mid] > v){
                r = mid-1;
            }
            
            else{
                l = mid+1;
            }
        }
        return r;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        long [] dist = new long [n];
        for(int i = 0; i < n; i++){
            long x = readInt(), y = readInt();
            dist [i] = x*x + y*y;
        }
        Arrays.sort(dist);
        for(int i = 0; i < q; i++){
            long r = readLong();
            r*=r;
            //find(r, dist);
            System.out.println(find(r, dist)+1);
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