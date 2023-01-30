import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] p, in;
    static List <Integer> [] rev;
    static int n, m;
    static boolean [] lose;
    public static void topo(Queue <Integer> q){
        while(!q.isEmpty()){
            int u = q.poll();
            lose [u] = true;
            for(int v : rev [u]){
                if(p [v] == 1 && in [v] != 0){
                    q.add(v);
                    in [v] = 0;
                }
                else if(p [v] == 0){
                    in [v]--;
                    if(in [v] == 0){
                        q.add(v);
                    }
                }
            }
        }
    }
    public static void main(String [] args) throws IOException{
        n = readInt(); m = readInt(); rev = new ArrayList [n+1]; p = new int [n+1]; lose = new boolean [n+1]; in = new int [n+1]; 
        for(int i = 1; i <= n; i++){
            p [i] = readInt();
            rev [i] = new ArrayList();
        }
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt();
            in [x]++;
            rev [y].add(x);
        }
        Queue <Integer> q = new LinkedList();
        for(int i = 1; i <= n; i++){
            if(in [i] == 0){
                q.add(i);
            }
        }
        topo(q);
        for(int i = 1; i <= n; i++){
            if(lose [i]){
                System.out.print(1);
            }
            else{
                System.out.print(0);
            }
            System.out.print(i!=n? " " : "\n");
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