import java.io.*;
import java.util.*;
public class HelloWorld {
    static HashSet <Integer> ans [];
    static boolean [] vis;
    static int last [];
    static int [] p;
    static void dfs(int src, int parent){
        vis [src] = true;
        if(!vis [last [src]]){
            dfs(last [src], parent);
        }
        ans [p [parent]].addAll(ans [p [src]]);
        p [src] = p [parent];
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt();
        int [] a = new int [n+1]; last = new int [n+1];
        ans = new HashSet [n+1]; p = new int [n+1];
        for(int i = 1; i <= n; i++){
            a [i] = i; last [i] = i;
            ans [i] = new HashSet();
            ans [i].add(i);
            p [i] = i;
        }
        for(int i = 0; i < k; i++){
            int f = readInt(), s = readInt();
            last [a [f]] = s;
            last [a [s]] = f;
            ans [a [f]].add(s);
            ans [a [s]].add(f);
            int temp = a [f];
            a [f] = a [s];
            a [s] = temp;
        }
        vis = new boolean [n+1];
        for(int i = 1; i <= n; i++){
            if(!vis [i]) dfs(i, i);
        }
        for(int i = 1; i <= n; i++){
            System.out.println(ans [p[i]].size());
        }
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return Long.compare(v, p.v);
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