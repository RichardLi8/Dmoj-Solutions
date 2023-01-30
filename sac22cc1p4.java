import java.io.*;
import java.util.*;
public class HelloWorld {
    static long fac(long n, int cnt){
        if(cnt == 0) return 1;
        return n * fac(n-1, cnt-1);
    }
    static long memo [];
    public static void main(String [] args) throws IOException{
        int n = readInt();
        long [] freq = new long [101];
        int [] a = new int [n];
        for(int i = 0; i < n; i++){
            a [i] = readInt();
        }
        long ans = 0;
        for(int i = 0; i < n; i++){
            freq [a[i]]++;
            if(a [i] < 3 || i < 3) continue;
            for(int j = 1; j < a [i]; j++){
                for(int k = j; a[i]-j-k >= k; k++){
                    if(j == k && k == a[i]-j-k && freq [j] >= 3) ans += fac(freq [j], 3)/6;
                    else if(j == k && k != a [i]-j-k && freq [j] >= 2 && freq [a[i]-j-k] >= 1) ans += fac(freq [j], 2)/2*freq[a[i]-j-k];
                    else if(j != k && k == a [i]-j-k && freq [j] >= 1 && freq [k] >= 2) ans += fac(freq [k], 2)/2*freq[j];
                    else if(j != k && j == a [i]-j-k && freq [j] >= 2 && freq [k] >= 1) ans += fac(freq [j], 2)/2*freq[k];
                    else if(j != k && k != a [i]-j-k && j != a[i]-j-k && freq [j] != 0 && freq [k] != 0 && freq [a [i]-j-k] != 0) ans += freq [j] * freq [k] * freq [a[i]-j-k];
                }
            }
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(y != p.y) return -Integer.compare(y, p.y);
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
}