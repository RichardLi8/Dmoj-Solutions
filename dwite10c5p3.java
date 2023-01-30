import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        for(int t = 0; t < 5; t++){
            int n = readInt();
            int [] w = new int [n];
            int sum = 0;
            for(int i = 0; i <n ; i++){
                w [i] = readInt();
                sum += w [i];
            }
            int M = sum/2;
            boolean dp [] = new boolean [M + 1];
            dp [0] = true;
            for(int i = 0; i < n; i++){
                for(int j = M; j >= w [i]; j--){
                    if(dp [j-w[i]]) dp [j] = true;
                }
            }
            int ans = 0;
            for(int i = M; i >= 0; i--){
                if(dp [i]){
                    ans = i;
                    break;
                }
            }
            System.out.println(sum-ans-ans);
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