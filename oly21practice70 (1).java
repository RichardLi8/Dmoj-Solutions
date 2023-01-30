import java.io.*;
import java.util.*;
public class HelloWorld {
    static long calc(int [] a, long [] fact){
        int tot = 0;
        for(int i = 0; i < 4; i++) tot += a [i];
        long v = fact [tot];
        for(int i = 0; i < 4; i++){
            v/=fact [a[i]];
        }
        return v;
    }
    public static void main(String [] args) throws IOException{
        int a [] = new int [4], tot = 0;
        for(int i = 0; i < 4; i++) {
            tot += a [i] = readInt();
        }
        long k = readLong();
        long [] fact = new long [tot+1]; fact [0] = 1;
        for(int i = 1; i <= tot; i++) fact [i] = fact [i-1] * i;
        int [] out = new int [tot]; long v = 0;
        for(int i = 0; i < tot; i++){
            for(int j = 0; j < 4; j++){
                if(a [j] == 0){
                    continue;
                }
                a [j]--;
                long now = calc(a, fact);
                if(v + now >= k) {
                    out [i] = j;
                    break;
                }
                else {
                    a [j]++;
                    v += now;
                }
            }
        }
        for(int i = 0; i < tot; i++){
            System.out.print((char)(out [i] + 'A'));
        }
        System.out.println();
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return 0;
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