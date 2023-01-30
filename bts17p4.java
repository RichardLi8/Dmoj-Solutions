import java.io.*;
import java.util.*;

public class HelloWorld {
    
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt(), j = readInt(), M = (int)1e6+1;
        int [] times = new int [n+1];
        int dp [] = new int [n+1];
        for(int i = 1; i <= n; i++){
            times [i] = M;
            dp [i] = M;
        }
        int [] freq = new int [(int)1e6+2];
        TreeSet <Integer> min = new TreeSet();
        for(int i = 0; i < m; i++){
            times [readInt()] = readInt();
        }
        if(j == 0 && n == 0) {
            System.out.println(0);
            return;
        }
        else if(j == 0){
            System.out.println(-1);
            return;
        }
        freq [0]++; min.add(0);
        for(int i = 1; i <= n; i++){
            if(times [i] != M){
                dp [i] = Math.max(min.first(), times [i]);
            }
            if(i >= j){
                freq [dp [i-j]]--;
                if(freq [dp [i-j]] == 0) min.remove(dp [i-j]);
                freq [dp [i]]++;
                min.add(dp [i]);
            }
            else {
                min.add(dp [i]);
                freq [dp [i]]++;
            }
        }
        System.out.println(min.first() == M? -1: min.first());
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