import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] ppl = new int [n], points = new int [n];
        int total = 0;
        for(int i = 0; i < n; i++){
            ppl [i] = readInt();
            points [i] = readInt();
            total += points [i];
        }
        long dp [] = new long [total+1];
        int sum = 0;
        Arrays.fill(dp, (long) 1e18); dp [0] = 0;
        for(int i = 0; i < n; i++){
            int v = ppl [i], p = points [i];
            sum += p;
            for(int j = total; j >= p; j--){
                dp [j] = Math.min(dp [j], dp [j-p] + v/2 + 1);
            }
        }
        long ans = Long.MAX_VALUE;
        for(int i = sum/2 + 1; i <= total; i++){
            ans = Math.min(dp [i], ans);
        }
        System.out.println(ans);
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