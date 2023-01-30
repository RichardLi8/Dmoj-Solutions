import java.io.*;
import java.util.*;
public class HelloWorld {
    static long sum [], lft [], rit[], ans [], a [];
    static void comb(int pos){
        lft [pos] = Math.max(lft [2*pos], sum [2*pos] + lft [2*pos+1]);
        rit [pos] = Math.max(rit [2*pos+1], sum [2*pos+1] + rit [2*pos]);
        sum [pos] = sum [2*pos] + sum [2*pos+1];
        ans [pos] = Math.max(ans [2*pos], ans [2*pos+1]);
        ans [pos] = Math.max(ans [pos], rit [2*pos] + lft [2*pos+1]);
    }
    static void build(int l, int r, int pos){
        if(l == r){
            sum [pos] = a [l];
            lft [pos] = a [l];
            rit [pos] = a [l];
            ans [pos] = a [l];
            return;
        }
        int mid = (l+r)/2;
        build(l, mid, 2*pos); build(mid+1, r, 2*pos+1);
        comb(pos);
    }
    static void update(int l, int r, int idx, int val, int pos){
        if(l == r && l == idx){
            sum [pos] = val;
            lft [pos] = val;
            rit [pos] = val;
            ans [pos] = val;
            return;
        }
        int mid = (l+r)/2;
        if(idx <= mid){
            update(l, mid, idx, val, 2*pos);
        }
        else{
            update(mid+1, r, idx, val, 2*pos+1);
        }
        comb(pos);
    }
    static data query(int l, int r, int ql, int qr, int pos){
        if(l == ql && r == qr){
            return new data(sum [pos], lft [pos], rit [pos], ans [pos]);
        }
        int mid = (l+r)/2;
        if(qr <= mid){
            return query(l, mid, ql, qr, 2*pos);
        }
        else if(ql > mid){
            return query(mid+1, r, ql, qr, 2*pos+1);
        }
        else{
            data cur = new data();
            data lc = query(l, mid, ql, mid, 2*pos), rc = query(mid+1, r, mid+1, qr, 2*pos+1);
            cur.lft = Math.max(lc.lft, lc.sum + rc.lft);
            cur.rit = Math.max(rc.rit, rc.sum + lc.rit);
            cur.sum = lc.sum + rc.sum;
            cur.ans = Math.max(lc.ans, rc.ans);
            cur.ans = Math.max(cur.ans, lc.rit + rc.lft);
            return cur;
        }
    }
    static class data{
        long sum, lft, rit, ans;
        data(long a, long b, long c, long d){
            sum = a;
            lft = b;
            rit = c;
            ans = d;
        }
        data(){};
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();;
        a = new long [n+1]; sum = new long [4*n]; lft = new long [4*n]; rit = new long [4*n]; ans = new long [4*n];
        for(int i = 1; i <= n; i++) a [i] = readInt();
        build(1, n, 1);
        for(int i = 0; i < q; i++){
            char c = readChar();
            if(c == 'S'){
                update(1, n, readInt(), readInt(), 1);
            }
            else{
                data out = query(1, n, readInt(), readInt(), 1);
                System.out.println(out.ans);
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