import java.io.*;
import java.util.*;
public class HelloWorld {
    static int dist(int a, int b){
        return Math.abs(a-b);
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int L = 1, R = 1, valR = 0, valL = 0;
        for(int i = 0; i < n; i++){
            int newL = readInt(), newR = readInt();
            int dist = newR-newL;
            int newValR, newValL;
            newValR = Math.min(dist(L, newL) + dist + valL, dist(R, newL) + dist + valR);
            newValL = Math.min(dist(L, newR) + dist + valL, dist(R, newR) + dist + valR);
            L = newL; R = newR; valR = newValR; valL = newValL;
        }
        int ans = Math.min(dist(n, L) + valL, dist(n, R) + valR);
        System.out.println(ans + n - 1);
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