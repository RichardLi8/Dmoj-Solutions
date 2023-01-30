import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n, m;
        while((n = readInt()) + (m = readInt()) != 0){
            int grid [][] = new int [n][m];
            for(int i = 0; i < n; i++){
                String s = next();
                for(int j = 0; j < m; j++){
                    if(s.charAt(j) == '.');
                    else if(s.charAt(j) == '*'){
                        grid [i][j] = -1;
                    }
                    else{
                        grid [i][j] = s.charAt(j)-'0';
                    }
                }
            }
            int dp [][] = new int [n][m];
            dp [n-1][0] = grid [n-1][0];
            for(int i = n-2; i >= 0; i--){
                dp [i][0] = grid [i][0] == -1 || dp [i+1][0] == -1 ? -1 : grid [i][0] + dp [i+1][0];
            }
            for(int j = 1; j < m; j++){
                for(int i = 0; i < n; i++){
                    dp [i][j] = -1;
                    if(grid [i][j] == -1) continue;
                    int up = 0;
                    for(int k = i; k >= 0; k--){
                        if(grid [k][j] != -1){
                            up += grid [k][j];
                            if(dp [k][j-1] != -1){
                                dp [i][j] = Math.max(dp [i][j], dp [k][j-1] + up);
                            }
                        }
                        else break;
                    }
                    int down = 0;
                    for(int k = i; k < n; k++){
                        if(grid [k][j] != -1){
                            down += grid [k][j];
                            if(dp [k][j-1] != -1){
                                dp [i][j] = Math.max(dp [i][j], dp [k][j-1] + down);
                            }
                        }
                        else break;
                    }
                }
            }
            System.out.println(dp [n-1][m-1]);
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