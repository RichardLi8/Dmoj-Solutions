import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int ans = 0;
        Map <Long, Integer> pre = new HashMap();
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            long left = 0, right = 0;
            long p = 1;
            int tohere = 1;
            for(int j = 0; j < s.length(); j++){
                left += (s.charAt(j)) * p;
                right = right * 131 + s.charAt(s.length()-j-1);
                p *= 131;
                if(left == right){
                    if(pre.containsKey(left)){
                        tohere = Math.max(pre.get(left)+1, tohere);
                    }
                }
            }
            pre.put(left, tohere);
            ans = Math.max(ans, tohere);
        }
        System.out.println(ans);
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