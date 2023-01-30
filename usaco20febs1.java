import java.io.*;
import java.util.*;
public class HelloWorld {
    static void cycle(int src){
        vis [src] = true;
        cycles [src].add(src); cycle [src] = src;
        int cur = last [src], cnt = 1; pos [src] = 0;
        while(!vis [cur]){
            cycles [src].add(cur);
            cycle [cur] = src;
            pos [cur] = cnt++;
            vis [cur] = true;
            cur = last [cur];
        }
    }
    static int [] last, cycle, pos;
    static boolean [] vis;
    static List <Integer> [] cycles;
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt(), k = readInt();
        last = new int [n+1]; int [] a = new int [n+1]; cycles = new ArrayList [n+1]; cycle = new int [n+1]; pos = new int [n+1];
        for(int i = 1; i <= n; i++){
            last [i] = i;
            a [i] = i;
            cycles [i] = new ArrayList();
        }
        for(int i = 0; i < m; i++){
            int l = readInt(), r = readInt();
            for(int j = 0; j < (r-l+1)/2; j++){
                last [a [l+j]] = r-j;
                last [a [r-j]] = l+j;
                int temp = a [l+j];
                a [l+j] = a [r-j];
                a [r-j] = temp;
            }
        }
        vis = new boolean [n+1];
        for(int i = 1; i <= n; i++){
            if(!vis [i]) cycle(i);
        }
        int [] ans = new int [n+1];
        for(int i = 1; i <= n; i++){
            int id = cycle [i], p = pos [i];
            ans [cycles [id].get((p+k)%cycles [id].size())] = i;
        }
        for(int i = 1; i <= n; i++){
            System.out.println(ans [i]);
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