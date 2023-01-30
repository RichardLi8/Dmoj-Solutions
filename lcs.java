import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        int one [] = new int [n+1];
        int two [] = new int [m+1];
        for(int i = 1; i <= n; i++) one [i] = readInt();
        for(int i = 1; i <= m; i++) two [i] = readInt();
        int dp [][] = new int [n+1][m+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(one [j] == two [i]){
                    dp [j][i] = dp [j-1][i-1]+1;
                }
                else{
                    dp [j][i] = Math.max(dp [j-1][i], dp [j][i-1]);
                }
            }
        }
        System.out.println(dp [n][m]);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine() throws IOException {
        return br.readLine();
    }
}