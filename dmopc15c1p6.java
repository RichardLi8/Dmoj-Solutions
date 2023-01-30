import java.io.*;
import java.util.*;
public class HelloWorld {
    static long seg [], a [], lazy [];
    static void build(int l, int r, int pos){
        if(l == r){
            seg [pos] = a [l];
            return;
        }
        int mid = (l+r)/2;
        build(l, mid, 2*pos); build(mid+1, r, 2*pos+1);
        seg [pos] = (seg [2*pos] + seg [2*pos+1])%m;
    }
    static void update(int l, int r, int ul, int ur, int val, int pos){
        if(l == ul && r == ur){
            seg [pos] = (seg [pos] + val * (r-l+1))%m;
            lazy [pos] = (lazy [pos] + val)%m;
            return;
        }
        int mid = (l+r)/2;
        pushDown(pos, l, r);
        if(ur <= mid){
            update(l, mid, ul, ur, val, 2*pos);
        }
        else if(ul > mid){
            update(mid+1, r, ul, ur, val, 2*pos+1);
        }
        else{
            update(l, mid, ul, mid, val, 2*pos); update(mid+1, r, mid+1, ur, val, 2*pos+1);
        }
        seg [pos] = (seg [2*pos] + seg [2*pos+1])%m;
    }
    static long query(int l, int r, int ql, int qr, int pos){
        if(l == ql && r == qr){
            return seg [pos];
        }
        int mid = (l+r)/2;
        pushDown(pos, l, r);
        if(qr <= mid){
            return query(l, mid, ql, qr, 2*pos);
        }
        else if(ql > mid){
            return query(mid+1, r, ql, qr, 2*pos+1);
        }
        else{
            return (query(l, mid, ql, mid, 2*pos) + query(mid+1, r, mid+1, qr, 2*pos+1))%m;
        }
    }
    static void pushDown(int pos, int l, int r){
        if(lazy [pos] != 0){
            int mid = (l+r)/2;
            seg [2*pos] = (seg [2*pos] + lazy [pos] * (mid-l+1))%m;
            seg [2*pos+1] = (seg [2*pos+1] + lazy [pos] * (r-mid))%m;
            lazy [2*pos] = (lazy [2*pos] + lazy [pos])%m;
            lazy [2*pos+1] = (lazy [2*pos+1] + lazy [pos])%m;
            lazy [pos] = 0;
        }
    }
    static int m;
    public static void main(String [] args) throws IOException{
        m = readInt(); int n = readInt(), q = readInt();
        a = new long [n+1]; seg = new long [4*n]; lazy = new long [4*n];
        for(int i = 1; i <= n; i++){
            a [i] = readInt()%m;
        }
        build(1, n, 1);
        for(int i = 0; i < q; i++){
            int c = readInt();
            if(c == 1){
                int l = readInt(), r = readInt(), x = readInt()%m;
                update(1, n, l, r, x, 1);
            }
            else{
                int l = readInt(), r = readInt();
                System.out.println(query(1, n, l, r, 1));
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine();
    }
}