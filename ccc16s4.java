import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), ans = 0;
        int [] psa = new int [n+1];
        for(int i = 1; i <= n; i++){
            int a = readInt();
            ans = Math.max(ans, a);
            psa [i] = a + psa [i-1];
        }
        boolean dp [][] = new boolean [n+1][n+1];
        for(int i = n; i >= 1; i--){
            dp [i][i] = true;
            for(int j = i+1; j <= n; j++){
                for(int p = i, q = j; p < q;){
                    int sumL = psa [p]-psa [i-1], sumR = psa [j]-psa [q-1];
                    if(dp [i][p] && dp [q][j] && p+1 == q && sumL == sumR){
                        dp [i][j] = true;
                    }
                    else if(dp [i][p] && dp [q][j] && dp [p+1][q-1] && sumL == sumR){
                        dp [i][j] = true;
                    }
                    if(dp [i][j]) ans = Math.max(ans, psa [j]-psa[i-1]);
                    if(sumL < sumR) p++;
                    else q--;
                }
            }
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