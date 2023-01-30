import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt(), res = 0, testcase [] = new int [m];
        for(int i = 0; i < n; i++){
            char c [] = br.readLine().toCharArray(); boolean ac = true;
            for(int j = 0; j < m; j++){
                testcase [j] <<= 1;
                if(c [j] == 'X'){
                    ac = false;
                    testcase [j] |= 1;
                }
            }
            res = res << 1 | (ac?0:1);
        }
        if(res == 0){
            System.out.println("1\n1");
            return;
        }
        int dp [] = new int [1 << n], num [] = new int [1 << n], pre [] = new int [1 << n];
        Arrays.fill(dp, (int)1e9); dp [0] = 0;
        for(int i = 0; i < m; i++){
            for(int mask = 0; mask < (1 << n); mask++){
                int nmask = mask | testcase [i];
                if(dp [nmask] > dp [mask] + 1){
                    dp [nmask] = dp [mask] + 1;
                    pre [nmask] = mask;
                    num [nmask] = i+1;
                }
            }
        }
        System.out.println(dp [res]);
        for(int mask = res; mask != 0; mask = pre [mask]){
            System.out.print(num [mask] + " ");
        }
        System.out.println("");
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