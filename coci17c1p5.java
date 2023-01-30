import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] seg;
    static void build(int l, int r, int pos){
        if(l == r){
            seg [pos] = Integer.MAX_VALUE;
            return;
        }
        int mid = (l+r)/2;
        build(l, mid, 2*pos); build(mid+1, r, 2*pos+1);
        seg [pos] = Math.min(seg [2*pos], seg [2*pos+1]);
    }
    static void update(int l, int r, int idx, int val, int pos){
        if(l == r && l == idx){
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
    static int query(int l, int r, int ql, int qr, int val, int pos){
        if(l == ql && r == qr){
            if(seg [pos] > val) return Integer.MAX_VALUE;
            if(l == r) return l;
            int mid = (l+r)/2;
            if(seg [2*pos] <= val) return query(l, mid, ql, mid, val, 2*pos);
            else return query(mid+1, r, mid+1, qr, val, 2*pos+1);
        }
        int mid = (l+r)/2;
        if(qr <= mid){
            return query(l, mid, ql, qr, val, 2*pos);
        }
        else if(ql > mid){
            return query(mid+1, r, ql, qr, val, 2*pos+1);
        }
        else {
            return Math.min(query(l, mid, ql, mid, val, 2*pos), query(mid+1, r, mid+1, qr, val, 2*pos+1));
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        seg = new int [4*n]; build(1, n, 1);
        for(int i = 0; i < q; i++){
            char c = readChar();
            if(c == 'M'){
                int val = readInt(), idx = readInt();
                update(1, n, idx, val, 1);
            }
            else{
                int val = readInt(), l = readInt();
                int ans = query(1, n, l, n, val, 1);
                System.out.println(ans == Integer.MAX_VALUE? -1 : ans);
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