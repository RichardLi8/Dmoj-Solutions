import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int BT = readInt(), NP = readInt(), YP = readInt(), M = readInt();
        int ans = 0;
        for(int i = 0; i <= M; i++){
            for(int j = 0; j <= M; j++){
                for(int k = 0; k <= M; k++){
                    int sum = i * BT + j * NP + k * YP;
                    if(sum <= M && sum != 0){
                        System.out.println(i + " Brown Trout, " + j + " Northern Pike, " + k + " Yellow Pickerel");
                        ans++;
                    }
                }
            }
        }
        System.out.println("Number of ways to catch fish: " + ans);
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