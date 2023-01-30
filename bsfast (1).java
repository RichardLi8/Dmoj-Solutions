import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] seg, a;
    static void build(int l, int r, int pos){
        if(l == r){
            seg [pos] = a [l];
            return;
        }
        int mid = (l+r)/2;
        build(l, mid, 2*pos); build(mid+1, r, 2*pos+1);
        seg [pos] = Math.min(seg [2*pos], seg [2*pos+1]);
    }
    static void update(int l, int r, int idx, int val, int pos){
        if(l == r){
            seg [pos] = val;
            return;
        }
        int mid = (l+r)/2;
        if(idx <= mid){
            update(l, mid, idx, val, 2*pos);
        }
        else{
            update(mid+1, r, idx, val, 2*pos+1);
        }
        seg [pos] = Math.min(seg [2*pos], seg [2*pos+1]);
    }
    static int query(int l, int r, int ql, int qr, int v, int pos){
        if(l == ql && r == qr){
            if(seg [pos] >= v) return Integer.MAX_VALUE;
            if(l == r){
                return l;
            }
            int mid = (l+r)/2;
            if(seg [2*pos] < v) return query(l, mid, ql, mid, v, 2*pos);
            else return query(mid+1, r, mid+1, qr, v, 2*pos+1);
        }
        int mid = (l+r)/2;
        if(qr <= mid){
            return query(l, mid, ql, qr, v, 2*pos);
        }
        else if(ql > mid){
            return query(mid+1, r, ql, qr, v, 2*pos+1);
        }
        else{
            int left = query(l, mid, ql, mid, v, 2*pos);
            if(left == Integer.MAX_VALUE){
                return query(mid+1, r, mid+1, qr, v, 2*pos+1);
            }
            else return left;
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        a = new int [n+1]; seg = new int [4*n];
        for(int i = 1; i <= n; i++){
            a [i] = readInt();
        }
        build(1, n, 1);
        int pre = 0;
        for(int i = 0; i < q; i++){
            int c = readInt();
            if(c == 1){
                update(1, n, readInt()^pre, readInt()^pre, 1);
            }
            else{
                int l = readInt()^pre, r = readInt()^pre, k = readInt()^pre;
                pre = query(1, n, l, r, k, 1);
                System.out.println(pre);
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