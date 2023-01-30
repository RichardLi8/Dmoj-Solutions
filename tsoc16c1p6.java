import java.io.*;
import java.util.*;

public class HelloWorld {
    
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        int dp [][] = new int [n+1][m+1];
        char [] one = (" " + next()).toCharArray(), two = (" " + next()).toCharArray();
        int cnt = 0, add = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp [i][j] = (int) 1e9;
            }
        }
        for(int i = 1; i <= n; i++){
            if(cnt == 3) {
                cnt = 0;
                add+=1;
            }
            dp [i][0] = add;
            cnt++;
        }
        cnt = 0; add = 1;
        for(int j = 1; j <= m; j++){
            if(cnt == 3) {
                cnt = 0;
                add+=1;
            }
            dp [0][j] = add;
            cnt++;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(one [i] == two [j]) {
                    dp [i][j] = dp [i-1][j-1];
                }
                else {
                    for(int k = 1; k <=3; k++){
                        if(i-k >= 0){
                            dp [i][j] = Math.min(dp [i][j], dp [i-k][j] + 1);
                        }
                        if(j-k >= 0){
                            dp [i][j] = Math.min(dp [i][j], dp [i][j-k] + 1);
                        }
                    }
                    dp [i][j] = Math.min(dp [i][j], dp [i-1][j-1] + 1);
                }
            }
        }
        /*for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                System.out.print(dp [i][j] + " ");
            }
            System.out.println("");
        }*/
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
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
}