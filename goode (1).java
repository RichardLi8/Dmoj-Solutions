import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] seg, lazy;
    static void pushDown(int pos, int l, int r){
        lazy [pos]&=1;
        if(lazy [pos] == 0) return;
        lazy [2*pos]++;
        lazy [2*pos+1]++;
        lazy [pos] = 0;
        int mid = (l+r)/2;
        seg [2*pos] = mid-l+1-seg [2*pos];
        seg [2*pos+1] = r-mid-seg [2*pos+1];
    }
    static void build(int l, int r, int pos){
        if(l == r){
            seg [pos] = 1;
            return;
        }
        int mid = (l+r)/2;
        build(l, mid, 2*pos); build(mid+1, r, 2*pos+1);
        seg [pos] = seg [2*pos] + seg [2*pos+1];
    }
    static void update(int l, int r, int ul, int ur, int pos){
        if(l == ul && r == ur){
            seg [pos] = r-l+1-seg [pos];
            lazy [pos]++;
            return;
        }
        int mid = (l+r)/2;
        pushDown(pos, l, r);
        if(ur <= mid){
            update(l, mid, ul, ur, 2*pos);
        }
        else if(ul > mid){
            update(mid+1, r, ul, ur, 2*pos+1);
        }
        else{
            update(l, mid, ul, mid, 2*pos); update(mid+1, r, mid+1, ur, 2*pos+1);
        }
        seg [pos] = seg [2*pos] + seg [2*pos+1];
    }
    static int query(int l, int r, int v, int pos){
        if(l == r) return r;
        int mid = (l+r)/2;
        pushDown(pos, l, r);
        if(seg [2*pos] < v) return query(mid+1, r, v-seg [2*pos], 2*pos+1);
        else return query(l, mid, v, 2*pos);
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt(), k = readInt();
        seg = new int [4*n]; lazy = new int [4*n];
        build(1, n, 1);
        for(int i = 0; i < q; i++){
            update(1, n, readInt(), readInt(), 1);
            if(seg [1] < k){
                System.out.println("AC?");
                continue;
            }
            int ans = query(1, n, k, 1);
            System.out.println(ans);
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