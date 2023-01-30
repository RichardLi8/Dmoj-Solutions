import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        String s = " " +  next();
        int n = s.length()-1;
        int dp [][] = new int [n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i <= j) dp [i][j] = (int)1e9;
            }
        }
        for(int i = n; i >= 1; i--){
            dp [i][i] = 1;
            for(int j = i+1; j <= n; j++){
                dp [i][j] = Math.min(dp [i][j], 1 + dp [i+1][j]);
                dp [i][j] = Math.min(dp [i][j], check(s.charAt(i), s.charAt(j)) + dp [i+1][j-1]);
                for(int k = i+1; k < j; k++){
                    dp [i][j] = Math.min(dp [i][j], check(s.charAt(i), s.charAt(k)) + dp [i+1][k-1] + dp [k+1][j]);
                }
            }
        }
        System.out.println(dp [1][n]);
    }
    static int check(char a, char b){
        if((a == '(' && b == ')') || (a == '[' && b == ']')) return 0;
        return 2;
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