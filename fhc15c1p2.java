import java.io.*;
import java.util.*;
public class HelloWorld {
    static int solve() throws IOException{
        int n = readInt(), ans = 0;
        Set <Long> used = new HashSet();
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            long hash = 0;
            boolean done = false;
            for(int j = 0; j < s.length(); j++){
                hash = s.charAt(j) + hash * 131;
                if(!used.contains(hash) && !done){
                    used.add(hash);
                    ans += j+1;
                    done = true;
                }
                used.add(hash);
            }
            if(!done) ans += s.length();
        }
        return ans;
    }
    public static void main(String [] args) throws IOException{
        int t = readInt();
        for(int i = 1; i <= t; i++){
            System.out.println("Case #" + i + ": " + solve());
        }
    }
    static class pair{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
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