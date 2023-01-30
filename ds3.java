import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        seg tree = new seg(n);
        int [] a = new int [n+1];
        for(int i = 1; i <= n; i++){
            a [i] = readInt();
        }
        tree.build(1, 1, n, a);
        for(int i = 0; i < q; i++){
            char c = next().charAt(0);
            if(c == 'C'){
                tree.update(1, n, readInt(), readInt(), 1);
            }
            else if(c == 'M'){
                System.out.println(tree.queryMin(1, n, readInt(), readInt(), 1));
            }
            else if(c == 'G'){
                System.out.println(tree.queryGcd(1, n, readInt(), readInt(), 1));
            }
            else{
                System.out.println(tree.queryCnt(1, n, readInt(), readInt(), 1));
            }
        }
    }
    static class seg{
        int [] min, gcd, cnt;
        seg(int n){
            min = new int [1<<(33-Integer.numberOfLeadingZeros(n))];
            gcd = new int [1<<(33-Integer.numberOfLeadingZeros(n))];
            cnt = new int [1<<(33-Integer.numberOfLeadingZeros(n))];
        }
        static int gcd(int a, int b){
            if(a == 0){
                return b;
            }
            return gcd(b%a, a);
        }
        void build(int pos, int l, int r, int [] a){
            if(l == r){
                min [pos] = a [l];
                gcd [pos] = a [l];
                cnt [pos]++;
                return;
            }
            int mid = (l+r)/2;
            build(2*pos, l, mid, a); build(2*pos+1, mid+1, r, a);
            min [pos] = Math.min(min [2*pos], min [2*pos+1]);
            gcd [pos] = gcd(gcd [2*pos], gcd [2*pos+1]);
            if(gcd [pos] == gcd [2*pos]) cnt [pos] += cnt [2*pos];
            if(gcd [pos] == gcd [2*pos+1]) cnt [pos] += cnt [2*pos+1];
        }
        void update(int l, int r, int idx, int val, int pos){
            if(l == r && l == idx){
                min [pos] = val;
                gcd [pos] = val;
                cnt [pos] = 1;
                return;
            }
            int mid = (l+r)/2;
            if(idx <= mid){
                update(l, mid, idx, val, 2*pos);
            }
            else{
                update(mid+1, r, idx, val, 2*pos+1);
            }
            min [pos] = Math.min(min [2*pos], min [2*pos+1]);
            gcd [pos] = gcd(gcd [2*pos], gcd [2*pos+1]);
            cnt [pos] = 0;
            if(gcd [pos] == gcd [2*pos]) cnt [pos] += cnt [2*pos];
            if(gcd [pos] == gcd [2*pos+1]) cnt [pos] += cnt [2*pos+1];
        }
        int queryMin(int l, int r, int ql, int qr, int pos){
            if(l == ql && r == qr){
                return min [pos];
            }
            int mid = (l+r)/2;
            if(qr <= mid){
                return queryMin(l, mid, ql, qr, 2*pos);
            }
            else if(ql > mid){
                return queryMin(mid+1, r, ql, qr, 2*pos+1);
            }
            else{
                return Math.min(queryMin(l, mid, ql, mid, 2*pos), queryMin(mid+1, r, mid+1, qr, 2*pos+1));
            }
        }
        int queryGcd(int l, int r, int ql, int qr, int pos){
            if(l == ql && r == qr){
                return gcd [pos];
            }
            int mid = (l+r)/2;
            if(qr <= mid){
                return queryGcd(l, mid, ql, qr, 2*pos);
            }
            else if(ql > mid){
                return queryGcd(mid+1, r, ql, qr, 2*pos+1);
            }
            else{
                return gcd(queryGcd(l, mid, ql, mid, 2*pos), queryGcd(mid+1, r, mid+1, qr, 2*pos+1));
            }
        }
        int queryCnt(int l, int r, int ql, int qr, int pos){
            if(l == ql && r == qr){
                return cnt [pos];
            }
            int mid = (l+r)/2;
            if(qr <= mid){
                return queryCnt(l, mid, ql, qr, 2*pos);
            }
            else if(ql > mid){
                return queryCnt(mid+1, r, ql, qr, 2*pos+1);
            }
            else{
                int left = queryGcd(l, mid, ql, mid, 2*pos), right = queryGcd(mid+1, r, mid+1, qr, 2*pos+1);
                int cur = gcd(left, right), ans = 0;
                if(cur == left) ans += queryCnt(l, mid, ql, mid, 2*pos);
                if(cur == right) ans += queryCnt(mid+1, r, mid+1, qr, 2*pos+1);
                return ans;
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