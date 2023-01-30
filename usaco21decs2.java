import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] p;
    static int find(int x){
        if(p [x] != x) return p [x] = find(p [x]);
        return x;
    }
    static void merge(int x, int y){
        x = find(x); y = find(y);
        if(x == y) return;
        p [y] = p [x];
    }
    static long dist(ArrayList <Integer> nums, int v){
        long d = Long.MAX_VALUE;
        int l = 0, r = nums.size()-1;
        while(l < r){
            int mid = (l+r)/2;
            if(Math.abs(nums.get(mid)-v) > Math.abs(nums.get(mid+1)-v)){
                l = mid+1;
            }
            else r = mid;
        }
        d = Math.min(d, Math.abs(nums.get(r)-v));
        return d*d;
    }
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for(int q = 0; q < t; q++){
            int n = readInt(), m = readInt();
            p = new int [n+1];
            for(int i = 1; i <= n; i++){
                p [i] = i;
            }
            for(int i = 0; i < m; i++){
                int x = readInt(), y = readInt();
                merge(x, y);
            }
            long [] dist1 = new long [n+1], dist2 = new long [n+1];
            ArrayList <Integer> src1 = new ArrayList(), src2 = new ArrayList();
            for(int i = 1; i <= n; i++){
                if(find(i) == find(1)) src1.add(i);
                if(find(i) == find(n)) src2.add(i);
                dist1 [i] = (long)4e18;
                dist2 [i] = (long)4e18;
            }
            long ans = Long.MAX_VALUE;
            for(int i = 1; i <= n; i++){
                dist1 [find(i)] = Math.min(dist1 [find(i)], dist(src1, i));
                dist2 [find(i)] = Math.min(dist2 [find(i)], dist(src2, i));
                ans = Math.min(ans, dist1 [find(i)] + dist2 [find(i)]);
            }
            System.out.println(ans);
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
        return br.readLine().trim();
    }
}