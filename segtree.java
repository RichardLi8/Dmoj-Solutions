import java.io.*;
import java.util.*;
public class HelloWorld {
    static int seg [], a [];
    static void build(int pos, int l, int r){
        if(l == r){
            seg [pos] = a [l];
            return;
        }
        int mid = (l+r)/2;
        build(2*pos, l, mid); build(2*pos+1, mid+1, r);
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
    static int query(int l, int r, int ql, int qr, int pos){
        if(l == ql && r == qr){
            return seg [pos];
        }
        int mid = (l+r)/2;
        if(qr <= mid){
            return query(l, mid, ql, qr, 2*pos);
        }
        else if(ql > mid){
            return query(mid+1, r, ql, qr, 2*pos+1);
        }
        else{
            return Math.min(query(l, mid, ql, mid, 2*pos), query(mid+1, r, mid+1, qr, 2*pos+1));
        }
    }
    static int query(int l, int r){
        return query(0, n-1, l, r, 1);
    }
    static void update(int i, int v){
        update(0, n-1, i, v, 1);
    }
    static int n;
    public static void main(String [] args) throws IOException{
        n = readInt(); int q = readInt();
        seg = new int [1<<(33-Integer.numberOfLeadingZeros(n))]; a = new int [n];
        for(int i = 0; i < n; i++) a [i] = readInt();
        build(1, 0, n-1);
        for(int i = 0; i < q; i++){
            char c = next().charAt(0);
            if(c == 'Q'){
                System.out.println(query(readInt(), readInt()));
            }
            else{
                update(readInt(), readInt());
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
}