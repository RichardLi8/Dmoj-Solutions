import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int R = readInt(), C = readInt(); final int mod = (int) 1e9 + 7;
        List <Integer> lst = new ArrayList();
        long dp [][] = new long [R][3000], ans = 0;
        for(int mask = 0; mask < 1 << C-2; mask++){
            if((mask & mask << 1) == 0 && (mask & mask << 2) == 0){
                lst.add(mask); dp [0][lst.size()-1] = 1; ans++;
            }
        }
        List <Integer> adj [] = new ArrayList [lst.size()];
        for(int i = 0; i < lst.size(); i++){
            adj [i] = new ArrayList(); int mask = lst.get(i);
            for(int j = 0; j < lst.size(); j++){
                int mask2 = lst.get(j), nmask = mask2 | mask2 << 1 | mask2 >> 1;
                if((nmask & mask) == 0){
                    adj [i].add(j);
                }
            }
        }
        ans -= dp [0][0];
        for(int r = 1; r < R-1; r++){
            for(int i = 0; i < lst.size(); i++){
                for(int j : adj [i]){
                    dp [r][i] += dp [r-1][j];
                }                    
                dp [r][i] %= mod; ans = (ans + dp [r][i]) % mod;
            }
            ans = (ans - dp [r][0] + mod) % mod;
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