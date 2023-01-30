import java.io.*;
import java.util.*;

public class HelloWorld {
    
    public static void main(String[] args) throws IOException{
        int t = readInt(), n = readInt();
        int [] ppl = new int [n+1];
        int sum = 0;
        for(int i = 1 ; i <= n; i++){
            ppl [i] = readInt();
            sum += ppl [i];
        }
        int [] dp = new int [sum+1], prev = new int [sum+1], cur = new int [sum+1];
        Arrays.fill(dp, (int)1e9);
        dp [0] = 0;
        for(int i = 1; i <= n; i++){
           for(int j = sum; j >= ppl [i]; j--){
               if(dp [j-ppl[i]] < 1e9 && dp [j] == 1e9){
                   dp [j] = j;
                   cur [j] = i;
                   prev [j] = j-ppl [i];
               }
           } 
        }
        int ans [] = new int [n+1];
        Arrays.fill(ans, (int)1e9);
        int start = -1;
        for(int i = t; ;i--){
            if(dp [i] != 1e9){
                start = i;
                break;
            }
        }
        while(start != 0){
            ans [cur [start]] = prev [start];
            start = prev [start];
        }
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(ans [i] == 1e9) {
                ans [i] = cnt;
                cnt += ppl [i];
            }
        }
        for(int i = 1; i <= n; i++){
            System.out.print(ans [i] + " ");
        }
        System.out.println("");
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