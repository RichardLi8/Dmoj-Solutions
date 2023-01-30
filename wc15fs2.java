import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] p;
    static int find(int x){
        if(p [x] != x) return p [x] = find(p [x]);
        return x;
    }
    static boolean works(int [] cows, int [] water, int cnt){
        for(int i = 1; i <= n+m; i++) p [i] = 0;
        int [] freq = new int [idx.length];
        for(int i = 0; i < m; i++){
            p [water [i]] = water [i];
            freq [water [i]] += cnt;
        }
        for(int i = 1; i <= n+m; i++){
            if(p[i] == 0) p [i] = p [i-1];
        }
        for(int i = n-1; i >= 0; i--){
            int down = find(cows [i]);
            if(down == 0) return false;
            if(idx [cows [i]]-idx[down] > k) return false;
            freq [down]--;
            if(freq [down] == 0) p [down] = p [down-1];
        }
        return true;
    }
    static int n, m, k;
    static int idx [];
    public static void main(String[] args) throws IOException{
        n = readInt(); m = readInt(); k = readInt();
        int [] cows = new int [n], water = new int [m];
        for(int i = 0; i < n; i++) cows [i] = readInt();
        for(int i = 0; i < m; i++) water [i] = readInt();
        Arrays.sort(cows);
        Arrays.sort(water);
        idx = new int [n+m+1];
        int cnt = 0, pre = -1, c1 = 0, c2 = 0;
        while(c1 < n || c2 < m){
            if(c1 == n){
                if(pre != water [c2]){
                    idx [++cnt] = water [c2];
                    pre = water [c2];
                }
                water [c2++] = cnt;
            }
            else if(c2 == m){
                if(pre != cows [c1]){
                    idx [++cnt] = cows [c1];
                    pre = cows [c1];
                }
                cows [c1++] = cnt;
            }
            else{
                if(cows [c1] < water [c2]){
                    idx [++cnt] = cows [c1];
                    cows [c1++] = cnt;
                }
                else{
                    idx [++cnt] = water [c2];
                    water [c2++] = cnt;
                }
            }
        }
        p = new int [n+m+1];
        int l = 1, r = n;
        while(l <= r){
            int mid = (l+r)/2;
            if(works(cows, water, mid)) r = mid-1;
            else l = mid+1;
        }
        System.out.println(l == n+1? -1 : l);
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return 0;
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