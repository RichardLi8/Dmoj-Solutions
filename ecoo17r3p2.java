import java.io.*;
import java.util.*;
public class HelloWorld {
    static int mod = (int)1e9+7;
    public static void main(String [] args) throws IOException{
        for(int q = 0; q < 10; q++){
            int n = readInt();
            node root = new node();
            for(int i = 0; i < n; i++){
                String s = br.readLine().replace(".", " ");
                insert(root, s.split(" "));
            }   
            System.out.println((count(root.ch.get(0))+1)%mod);
        }
    }
    static void insert(node root, String [] s){
        for(int i = 0; i < s.length; i++){
            int n = Integer.parseInt(s [i]);
            if(root.ch.get(n) == null){
                root.ch.put(n, new node());
            }
            root = root.ch.get(n);
        }
    }
    static long count(node root){
        long cnt = 0; int chs = 0;
        for(int n : root.ch.keySet()){
            if(n > chs) chs = n;
            cnt = (cnt+count(root.ch.get(n)))%mod;
        }
        return (cnt+chs)%mod;
    }
    static class node{
        Map <Integer, node> ch;
        node(){
            ch = new TreeMap();
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