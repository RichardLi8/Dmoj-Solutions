import java.io.*;
import java.util.*;

public class HelloWorld {
    static int n;
    static List <Integer> adj [];
    public static void main(String[] args) throws IOException {
       n = readInt();
       adj = new ArrayList [n+1];
       for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
       int x = readInt(), y = readInt();
       while(x != 0 && y != 0){
           adj[x].add(y);
           x = readInt(); y = readInt();
       }
       System.out.println(paths());
    }
    static int paths(){
        int dp [] = new int [n+1];
        dp [1] = 1;
        Queue <Integer> q = new LinkedList();
        q.add(1);
        boolean visited [] = new boolean [n+1];
        visited [1] = true;
        while(!q.isEmpty()){
            int u = q.poll();
            for(Integer v : adj [u]){
                dp [v] += dp [u];
                if(!visited [v]){
                    q.add(v);
                    visited [v] = true;
                }
            }
        }
        return dp [n];
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
}