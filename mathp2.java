import java.io.*;
import java.util.*;

public class Random {
    public static void main(String[] args) throws IOException {
        int n = readInt(), mod = (int)1e9+7;
        long [] sum = new long [n+1], cnt = new long [n+1];
        cnt [0] = 1;
        for(int i = 1; i <= n; i++){
            long num = readInt();
            cnt [i] = cnt [i-1];
            sum [i] = ((sum [i-1]<<1)%mod + (cnt [i] * num)%mod)%mod;
            cnt [i] = (cnt [i] * 2)%mod;
        }
        System.out.println(sum [n]);
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return Integer.compare(v, p.v);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException{
        return Integer.parseInt(next());
    }
}