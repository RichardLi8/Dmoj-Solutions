import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int [] nums = new int [n+1];
        for(int i = 0; i < n; i++){
            nums [readInt()]++;
        }
        for(int i = 1; i <= n; i++){
            if(nums [i] > 1 || nums [i] == 0){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
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
}