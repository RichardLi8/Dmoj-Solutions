import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt();
        int [] freq = new int [n+1], a = new int [n+1];
        for(int i = 1; i <= n; i++){
            a [i] = readInt();
        }
        int r = 1, cnt = 1; long ans = 0; freq [a[1]]++;
        for(int i = 1; i <= n; i++){
            while(cnt < k && r < n){
                if(++freq [a [++r]] == 1) cnt++;
            }
            if(cnt < k) break;
            ans += n-r+1;
            if(--freq [a[i]] == 0) cnt--;
            
        }
        System.out.println(ans);
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