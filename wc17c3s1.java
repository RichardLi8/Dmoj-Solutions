import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [][] g;
    static boolean [][] ans;
    static boolean found = false;
    static void print(){
        ArrayList <pair> out = new ArrayList();
        for(int i = 0; i < ans.length ; i++){
            for(int j = i+1; j < ans.length; j++){
                if(ans [i][j]){
                    out.add(new pair(i+1, j+1));
                }
            }
        }
        System.out.println(out.size());
        for(pair p : out){
            System.out.println(p.x + " " + p.y);
        }
    }
    static int mutual(boolean [][] adj, int x, int y){
        int ret = 0;
        for(int i = 0; i < adj.length; i++){
            if(adj [x][i] && adj [y][i]){
                ret++;
            }
        }
        return ret;
    }
    static boolean check(boolean [][] adj){
        for(int i = 0; i < adj.length; i++){
            for(int j = i+1; j < adj.length; j++){
                if(mutual(adj, i, j) != g [i][j]) return false;
            }
        }
        return true;
    }
    static void perm(boolean [][] adj, int node, int cnt){
        if(cnt == adj.length){
            dfs(adj, node+1);
            return;
        }
        perm(adj, node, cnt+1);
        adj [node][cnt] = true; adj [cnt][node] = true;
        perm(adj, node, cnt+1);
        adj [node][cnt] = false; adj [cnt][node] = false;
    }
    static void dfs(boolean [][] adj, int node){
        if(node == adj.length && check(adj) && !found){
            ans = new boolean [adj.length][adj.length];
            for(int i = 0; i < adj.length; i++){
                for(int j = 0; j < adj.length; j++){
                    ans [i][j] = adj [i][j];
                }
            }
            found = true;
            return;
        }
        else if(node == adj.length) return;
        perm(adj, node, node+1);
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(); g = new int [n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                g [i][j] = readInt();
            }
        }
        dfs(new boolean [n][n], 0);
        if(!found){
            System.out.println("Impossible");
            return;
        }
        print();
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(y != p.y) return -Integer.compare(y, p.y);
            return Integer.compare(x, p.x);
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