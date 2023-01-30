import java.io.*;
import java.util.*;
public class HelloWorld {
    static long [] seg, lazy;
    static void down(int pos){
        if(lazy [pos] == 0) return;
        lazy [2*pos] += lazy [pos];
        lazy [2*pos+1] += lazy [pos];
        seg [2*pos] += lazy [pos];
        seg [2*pos+1] += lazy [pos];
        lazy [pos] = 0;
    }
    static void build(int l, int r, int pos){
        if(l == r){
            seg [pos] = 0;
            return;
        }
        int mid = (l+r)/2;
        build(l, mid, 2*pos); build(mid+1, r, 2*pos+1);
        seg [pos] = Math.max(seg [2*pos], seg [2*pos+1]);
    }
    static void update(int l, int r, int ul, int ur, int val, int pos){
        if(l == ul && r == ur){
            lazy [pos] += val;
            seg [pos] += val;
            return;
        }
        down(pos);
        int mid = (l+r)/2;
        if(ur <= mid){
            update(l, mid, ul, ur, val, 2*pos);
        }
        else if(ul > mid){
            update(mid+1, r, ul, ur, val, 2*pos+1);
        }
        else{
            update(l, mid, ul, mid, val, 2*pos); 
            update(mid+1, r, mid+1, ur, val, 2*pos+1);
        }
        seg [pos] = Math.max(seg [2*pos], seg [2*pos+1]);
    }
    static long query(int l, int r, int ql, int qr, int pos){
        if(l == ql && r == qr){
            return seg [pos];
        }
        int mid = (l+r)/2;
        down(pos);
        if(qr <= mid){
            return query(l, mid, ql, qr, 2*pos);
        }
        else if(ql > mid){
            return query(mid+1, r, ql, qr, 2*pos+1);
        }
        else {
            return Math.max(query(l, mid, ql, mid, 2*pos), query(mid+1, r, mid+1, qr, 2*pos+1));
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt(), q = readInt();
        seg = new long [4*n]; lazy = new long [4*n];
        for(int i = 0; i < q; i++){
            int c = readInt();
            if(c == 0){
                int idx = readInt(), val = readInt();
                update(0, n-1, Math.max(0, idx-k+1), idx, val, 1);
            }
            else{
                System.out.println(query(0, n-1, Math.max(readInt(), 0), Math.min(readInt(), n-1), 1));
            }
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Integer.compare(y, p.y);
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine();
    }
}