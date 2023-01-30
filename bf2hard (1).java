import java.io.*;
import java.util.*;
public class HelloWorld {
    static long [] hash1, hash2, p1, p2;
    static int k;
    static String s;
    static long getSub1(int l, int r){
        return hash1 [r]-hash1 [l-1]*p1 [r-l+1];
    }
    static long getSub2(int l, int r){
        return hash2 [r]-hash2 [l-1]*p2 [r-l+1];
    }
    public static void main(String [] args) throws IOException{
        s = " " + next(); k = readInt(); int n = s.length()-1;
        hash1 = new long [n+1]; hash2 = new long [n+1]; p1 = new long [n+1]; p2 = new long [n+1];
        p1 [0] = 1; p2 [0] = 1;
        int min = 1;
        for(int i = 1; i <= n; i++){
            hash1 [i] = hash1 [i-1]*131 + s.charAt(i);
            hash2 [i] = hash2 [i-1]*137 + s.charAt(i);
            p1 [i] = p1 [i-1] * 131;
            p2 [i] = p2 [i-1] * 137;
        }
        for(int i = 2; i <= n-k+1; i++){
            int l = 1, r = k;
            while(l <= r){
                int mid = (l+r)/2;
                if(getSub1(min, min+mid-1) != getSub1(i, i+mid-1) || (getSub2(min, min+mid-1) != getSub2(i, i+mid-1))){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            if(r != k && s.charAt(min+r) > s.charAt(i+r)){
                min = i;
            }
        }
        System.out.println(s.substring(min, min+k));
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