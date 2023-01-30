import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class Main {
    static long [][] memo = new long [64][64];
    static boolean [][] vis = new boolean [64][64];
    static long findAns(int n, int p){
        if(p == 2 && n >= 2) return 1;
        else if(p == 2 && n < 2) return 0;
        else if(p == 1 && n > 0) return 1;
        long ans = 0;
        for(int i = 1; i <= n/2; i++){
            if(!vis [n-2*i][p-2]){
                memo [n-2*i][p-2] = findAns(n-2*i, p-2);
                vis [n-2*i][p-2] = true;
            }
            ans += memo [n-2*i][p-2];
        }
        return ans;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        long ans = 1;
        if(n%2 == 0){
            for(int i = 2; i <= n; i++){
                ans += findAns(n, i);
            }
        }
        else{
            for(int i = 3; i <= n; i += 2){
                ans += findAns(n, i);
            }
        }
        System.out.println(ans);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException{
        return Integer.parseInt(next());
    }
}