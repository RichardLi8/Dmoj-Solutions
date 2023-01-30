import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int x = readInt();
        if(x == 1){
            int d = readInt(), n = readInt(), p = readInt();
            int [] f = new int [d+1], dp = new int [d+2];
            for(int i = 1; i <= p; i++){
                int pos = readInt(), fuel = readInt();
                f [pos] = fuel;
            }
            int mod = (int) 1e9+7;
            dp [0] = 1;  dp [n+1] = (-1+mod)%mod;
            for(int i = 1; i <= d; i++){
                dp [i] = dp [i] = (dp [i]+dp [i-1])%mod;
                if(f [i] > 0){
                    dp [i+1] = (dp [i+1] + dp [i])%mod;
                    int t = Math.min(i+f[i]+1, d+1);
                    dp [t] = (dp [t]-dp [i]+mod)%mod;
                }
            }
            System.out.println(dp [d]);
        }
        else{
            int w = readInt(), num = 30, dst = num+2;
            System.out.println(num+2 + " " + num + " " + num);
            for(int i = 1; i <= num; i++){
                if((w&1<<(i-1)) > 0) System.out.println(i + " " + (dst-i));
                else System.out.println(i + " " + (dst-i-1));
            }
        }
    }
    static class data implements Comparable <data>{
        char c; int x, i, p;
        data(char a, int b, int c, int d){
            this.c = a;
            x = b;
            i = c;
            p = d;
        }
        public int compareTo(data d){
            return Integer.compare(i, d.i);
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return Integer.compare(y, p.y);
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