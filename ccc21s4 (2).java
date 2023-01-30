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
    static int n;
    public static void main(String [] args) throws IOException{
        int n = readInt(), w = readInt(), d = readInt();
        List <Integer> adj [] = new ArrayList [n+1];
        for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
        for(int i = 0; i < w; i++){
            int x = readInt(), y = readInt();
            adj [y].add(x);
        }
        Queue <Integer> q = new LinkedList();
        int [] dist = new int [n+1];
        Arrays.fill(dist, (int)1e9);
        dist [n] = 0;
        q.add(n);
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj [u]){
                if(dist [v] > dist [u]){
                    dist [v] = dist [u]+1;
                    q.add(v);
                }
            }
        }
        int [] trains = new int [n+1]; a = new int [n+1];
        for(int i = 1; i <= n; i++){
            trains [i] = readInt();
            if(dist [trains [i]] == 1e9){
                a [trains [i]] = (int) 1e9;
            }
            else{
                a [trains [i]] = dist [trains [i]] + i-1;
            }
        }
        seg = new int [1<<(33-Integer.numberOfLeadingZeros(n))];
        build(1, 1, n);
        for(int i = 0; i < d; i++){
            int x = readInt(), y = readInt();
            if(dist [trains[x]] != 1e9){
                update(1, n, trains [x], dist [trains[x]] + y-1, 1);
            }
            if(dist [trains[y]] != 1e9){
                update(1, n, trains [y], dist [trains [y]] + x-1, 1);
            }
            int temp = trains [x];
            trains [x] = trains [y];
            trains [y] = temp;
            System.out.println(query(1, n, 1, n, 1));
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