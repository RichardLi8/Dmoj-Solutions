import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), dp [][] = new int [2*n+1][2*n+1];
        for(int i = 1; i <= n; i++){
            dp [i+n][i+n] = dp [i][i] = readInt()%2;
        }
        for(int i = 2*n; i >= 1; i--){
            for(int j = i + 1; j <= 2*n; j++){
                dp [i][j] = Math.max(dp [i][i] - dp [i+1][j], dp [j][j] - dp [i][j-1]);
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(dp [i][i] - dp [i+1][i-1+n] > 0) ans++;
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