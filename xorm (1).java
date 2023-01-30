import java.io.*;
import java.util.*;
public class HelloWorld {
    static void insert(node root, int v, int idx){
        for(int i = 30; i >= 0; i--){
            int b = (v & (1 << i)) >= 1? 1 : 0;
            if(root.ch [b] == null){
                root.ch [b] = new node();
            }
            if(root.ch [b].i > idx) root.ch [b].i = idx;
            root = root.ch [b];
        }
    }
    static int find(node root, int v){
        for(int i = 30; i >= 0; i--){
            int b = (v & (1 << i)) >= 1? 1 : 0;
            if(root.ch [b] != null){
                root = root.ch [b];
            }
            else{
                root = root.ch [b^1];
            }
        }
        return root.i;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        node root = new node();
        for(int i = 0; i < n; i++){
            insert(root, readInt(), i);
        }
        int v = 0;
        for(int i = 0; i < q; i++){
            System.out.println(find(root, v^=readInt()));
        }
    }
    static class node{
        int i = Integer.MAX_VALUE; node [] ch = new node [2];
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            return p.w-w;
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