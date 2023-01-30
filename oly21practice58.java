import java.io.*;
import java.util.*;
public class HelloWorld {
    static boolean [] vis;
    public static void main(String [] args) throws IOException{
        int n = readInt(); long k = readLong();
        vis = new boolean [n+1];
        int [] go = new int [n+1];
        for(int i = 1; i <= n; i++){
            go [i] = readInt();
        }
        Queue <Integer> q = new LinkedList();
        q.add(1);
        long len = 0;
        long [] start = new long [n+1];
        long mod = 0;
        int ans = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            if(len == k){
                System.out.println(u);
                return;
            }
            if(vis [u]) {
                mod = len-start [u];
                ans = u;
                break;
            }
            vis [u] = true;
            start [u] = len;
            len++;
            q.add(go [u]);
        }
        long m = (k-start [ans])%mod;
        for(int i = 0; i < m; i++){
            ans = go [ans];
        }
        System.out.println(ans);
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