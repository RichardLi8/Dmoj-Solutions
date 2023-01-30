import java.io.*;
import java.util.*;
public class HelloWorld {
    static double memo [] = new double [1 << 21], nums [][];
    static boolean vis [] = new boolean [1 << 21];
    static int n;
    static double dfs(int state, int pos){
        if(pos == n) return 1.0;
        if(vis [state] == true) return memo [state];
        for(int i = 0; i < n; i++){
            if((state & 1 << i) == 0){
                memo [state] = Math.max(memo [state], nums [pos][i] * dfs(state | 1 << i, pos+1));
            }
        }
        vis [state] = true;
        return memo [state];
    }
    
    public static void main(String [] args) throws IOException{
        n = readInt();
        nums = new double [n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                nums [i][j] = readDouble()/100;
            }
        }
        System.out.printf("%.6f\n", dfs(0, 0) * 100);
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