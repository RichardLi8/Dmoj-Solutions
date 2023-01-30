import java.io.*;
import java.util.*;
public class HelloWorld {
    static long [][] bit;
    static void update(int r, int c, long v){
        for(int i = r; i < bit.length; i += i&-i){
            for(int j = c; j < bit.length; j += j&-j){
                bit [i][j] = Math.max(bit [i][j], v);
            }
        }
    }
    static long query(int r, int c){
        long max = 0;
        for(int i = r; i > 0; i -= i&-i){
            for(int j = c; j > 0; j -= j&-j){
                max = Math.max(max, bit [i][j]);
            }
        }
        return max;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        block [] a = new block [n+1];
        for(int i = 1; i <= n; i++){
            a [i] = new block(readInt(), readInt(), readInt(), readInt(), i);
            if(a [i] .l > a [i] .w){
                int temp = a [i].l;
                a [i].l = a [i].w;
                a [i].w = temp;
            }
        }
        Arrays.sort(a, 1, n+1);
        bit = new long [5001][5001];
        long [] dp = new long [n+1];
        long ans = 0;
        int last = 0;
        for(int i = 1; i <= n; i++){
            dp [i] = query(a [i].l, a [i].w) + a[i].p;
            update(a [i].l, a [i].w, dp [i]);
            if(dp [i] > ans){
                ans = dp [i]; last = i;
            }
        }
        System.out.println(ans);
        List <Integer> pre = new ArrayList();
        pre.add(a [last].id);
        for(int i = last, j = last-1; j > 0; j--){
            if(dp [i] == dp [j] + a[i].p && a [j].l <= a [i].l && a [j].w <= a [i].w){
                pre.add(a [j].id);
                i = j;
            }
        }
        System.out.println(pre.size());
        for(int v : pre){
            System.out.print(v + " ");
        }
        System.out.println();
    }
    static class block implements Comparable <block>{
        int l, w, h, p, id;
        block(int a, int b, int c, int d, int e){
            l = a;
            w = b;
            h = c;
            p = d;
            id = e;
        }
        public int compareTo(block b){
            if(h == b.h){
                if(l == b.l){
                    return Integer.compare(w, b.w);
                }
                return Integer.compare(l, b.l);
            }
            return Integer.compare(h, b.h);
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return -Integer.compare(y, p.y);
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