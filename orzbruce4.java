import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> adj [];
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt(), k = readInt();
        adj = new ArrayList [n+1];
        for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt();
            adj [x].add(y);
            adj [y].add(x);
        }
        int adam [] = new int [n+1];
        int bruce [] = new int [n+1];
        dist(adam, 1);
        dist(bruce, n);
        int cnt = 0;
        int mod = (int)1e9 + 7;
        for(int i = 2; i < n; i++){
            if(adam [i] <= k && bruce [i] <= k) cnt++;
        }
        long ans = 1;
        for(int i = 1; i <= cnt; i++){
            ans *= 2;
            ans%=mod;
        }
        System.out.println(ans);
    }
    static void dist(int dist [], int src){
        Queue <Integer> q = new LinkedList();
        Arrays.fill(dist, (int)1e9);
        dist [src] = 0;
        q.add(src);
        while(!q.isEmpty()){
            int u = q.poll();
            for(Integer v : adj [u]){
                if(dist [v] == 1e9) {
                    dist [v] = dist [u] + 1;
                    q.add(v);
                }
            }
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