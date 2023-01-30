import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(); long d = readLong(); int k = readInt(), x = readInt();
        long [] speeds = new long [n];
        for(int i = 0; i < n; i++){
            speeds [i] = readLong();
        }
        long p = readLong();
        int reduce = (100-x);
        Arrays.sort(speeds);
        for(int i = n-1; i >= 0; i--){
            int cnt = 0;
            long a = speeds [i], b = p;
            while(a >= b){
                a *= reduce; b *= 100;
                cnt++;
                if(a >= 100 && b >= 100){
                    a/=100; b/=100;
                }
            }
            k-=cnt;
            if(k < 0) break;
        }
        System.out.println(k < 0? "NO" : "YES");
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