import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), x = readInt();
        if(x%2 != n%2){
            System.out.println(-1);
            return;
        }
        int cnt = 0, alt = 1;
        for(int i = 0; i < n; i++){
            if(cnt <= x){
                System.out.print(1);
                cnt++;
            }
            else System.out.print((alt ^= 1));
            if(i != n-1){
                System.out.print(" ");
            }
        }
        System.out.println("");
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