import java.io.*;
import java.util.*;
public class HelloWorld {
    public static long find(int st, int ed, long [] psa){
        int l = st, r = ed;
        while(l < r){
            int mid = (l+r)/2;
            long curdiff = Math.abs(psa [mid]-psa[st-1]-(psa [ed]-psa[mid]));
            long newdiff = Math.abs(psa [mid+1]-psa[st-1]-(psa [ed]-psa[mid+1]));
            if(curdiff > newdiff){
                l = mid+1;
            }
            else r = mid;
        }
        return Math.abs(psa [l]-psa[st-1]-(psa [ed]-psa [l]));
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] nums = new int [n*2 + 1];
        long [] psa = new long [n*2 + 1];
        for(int i = 1; i <= n; i++){
            nums [i] = nums [n+i] = readInt();
        }
        for(int i = 1; i <= n*2; i++){
            psa [i] = psa [i-1] + nums [i];
        }
        for(int i = 1; i <= n; i++){
            find(i, i+n-1, psa);
            System.out.print(find(i, i+n-1, psa) + (i == n? "\n":" "));
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