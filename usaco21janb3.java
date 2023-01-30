import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int cows [] = new int [n], barns [] = new int [n];
        for(int i = 0; i < n; i++) cows [i] = readInt();
        for(int i = 0; i < n; i++) barns [i] = readInt();
        Arrays.sort(barns);
        Arrays.sort(cows);
        long ans = 1;
        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(cows [j] <= barns [i]) cnt++;
                else break;
            }
            ans *= (cnt-i);
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}