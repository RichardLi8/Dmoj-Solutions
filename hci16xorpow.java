import java.io.*;
import java.util.*;
public class HelloWorld {
    static void insert(node root, int v){
        for(int i = 0; i < 32; i++){
            int b = (v & (1 << i)) >= 1? 1 : 0;
            if(root.ch [b] == null){
                root.ch [b] = new node();
            }
            root.ch [b].c++;
            root = root.ch [b];
        }
    }
    static int find(node root, int v){
        for(int i = 0; i < 32; i++){
            int b = (v & (1 << i)) >= 1? 1 : 0;
            if(root.ch [b] == null) return 0;
            root = root.ch [b];
        }
        return root.c;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt();
        node root = new node(); insert(root, 0);
        List <Integer> pow = new ArrayList();
        int p = 1;
        while(p * k > 0){
            p *= k;
            pow.add(p);
        }
        int v = 0; long ans = 0;
        for(int i = 0; i < n; i++){
            v ^= readInt();
            insert(root, v);
            for(int j = 0; j < pow.size(); j++){
                ans += find(root, pow.get(j)^v);
            }
        }
        System.out.println(ans);
    }
    static class node{
        int c; node [] ch = new node [2];
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