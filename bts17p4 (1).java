import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt(),j = readInt();
        if(j > n){System.out.println(0); return;}
        if(j == 0){System.out.println(-1); return;}
        int dp [] = new int [n+2], freq [] = new int [1000001]; 
        dp [n+1] = -1;
        for(int i = 0; i < m; i++){
            int p = readInt(), t = readInt();
            dp [p] = t;
        }
        TreeSet <Integer> min = new TreeSet();
        for(int i = 1; i <= j; i++){
            if(dp [i] != 0) {
                min.add(dp [i]);
                freq [dp [i]]++;
            }
        }
        for(int i = j+1; i <= n+1; i++){
            if(min.isEmpty()) break;
            if(dp [i] != 0){
                dp [i] = Math.max(dp [i], min.first());
                freq [dp [i]]++;
                min.add(dp [i]);
            }
            if(dp [i-j] != 0) {
                freq [dp [i-j]]--;
                if(freq [dp [i-j]] == 0) min.remove(dp [i-j]);
            }
        }
        System.out.println(dp [n+1]);
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