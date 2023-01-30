import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        for(int t = readInt(); t > 0; t--){
            int n = readInt();
            String s = br.readLine();
            int [] w = new int [n+1], r = new int [n+1];
            for(int i = 1; i <= n; i++){
                if(s.charAt(i-1) == 'R'){
                    r [i]++;
                }
                else{
                    w [i]++;
                }
                w [i] += w [i-1];
                r [i] += r [i-1];
            }
            int idx = 1, ans = Integer.MAX_VALUE;
            for(int i = 3; i <= n; i++){
                int newidx = i-2;
                if(w [idx] + r [i-1]-r[idx] > w [newidx] + r [i-1]-r[newidx]){
                    idx = newidx;
                }
                ans = Math.min(ans, w [idx] + r [i-1]-r [idx] + w [n]-w[i-1]);
            }
            System.out.println(ans);
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