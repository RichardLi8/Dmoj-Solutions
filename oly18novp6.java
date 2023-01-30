import java.io.*;
import java.util.*;
public class HelloWorld {
    static long sum [], max [], a [];
    static void build(int l, int r, int pos){
        if(l == r){
            sum [pos] = a [l];
            max [pos] = a [l];
            return;
        }
        int mid = (l+r)/2;
        build(l, mid, 2*pos); build(mid+1, r, 2*pos+1);
        sum [pos] = sum [2*pos] + sum [2*pos+1];
        max [pos] = Math.max(max [2*pos], max [2*pos+1]);
    }
    static void update(int l, int r, int ul, int ur, int pos){
        if(l == r && l == ul && r == ur){
            sum [pos] = (int) Math.sqrt(sum [pos]);
            max [pos] = (int) Math.sqrt(max [pos]);
            return;
        }
        int mid = (l+r)/2;
        if(ur <= mid){
            if(queryMax(l, mid, ul, ur, 2*pos) > 1) update(l, mid, ul, ur, 2*pos);
        }
        else if(ul > mid){
            if(queryMax(mid+1, r, ul, ur, 2*pos+1) > 1) update(mid+1, r, ul, ur, 2*pos+1);
        }
        else{
            if(queryMax(l, mid, ul, mid, 2*pos) > 1) update(l, mid, ul, mid, 2*pos); 
            if(queryMax(mid+1, r, mid+1, ur, 2*pos+1) > 1) update(mid+1, r, mid+1, ur, 2*pos+1);
        }
        sum [pos] = sum [2*pos] + sum [2*pos+1];
        max [pos] = Math.max(max [2*pos], max [2*pos+1]);
    }
    static long querySum(int l, int r, int ql, int qr, int pos){
        if(l == ql && r == qr){
            return sum [pos];
        }
        int mid = (l+r)/2;
        if(qr <= mid){
            return querySum(l, mid, ql, qr, 2*pos);
        }
        else if(ql > mid){
            return querySum(mid+1, r, ql, qr, 2*pos+1);
        }
        else{
            return querySum(l, mid, ql, mid, 2*pos) + querySum(mid+1, r, mid+1, qr, 2*pos+1);
        }
    }
    static long queryMax(int l, int r, int ql, int qr, int pos){
        if(l == ql && r == qr){
            return max [pos];
        }
        int mid = (l+r)/2;
        if(qr <= mid){
            return queryMax(l, mid, ql, qr, 2*pos);
        }
        else if(ql > mid){
            return queryMax(mid+1, r, ql, qr, 2*pos+1);
        }
        else{
            return Math.max(queryMax(l, mid, ql, mid, 2*pos), queryMax(mid+1, r, mid+1, qr, 2*pos+1));
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        a = new long [n+1]; sum = new long [4*n]; max = new long [4*n];
        for(int i = 1; i <= n; i++) a [i] = readInt();
        build(1, n, 1);
        int q = readInt();
        for(int i = 0; i < q; i++){
            int c = readInt();
            if(c == 1){
                System.out.println(querySum(1, n, readInt(), readInt(), 1));
            }
            else{
                update(1, n, readInt(), readInt(), 1);
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