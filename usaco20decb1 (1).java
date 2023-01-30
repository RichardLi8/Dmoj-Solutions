import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int nums [] = new int [7];
        for(int i = 0; i < 7; i++){
            nums [i] = readInt();
        }
        Arrays.sort(nums);
        int total = nums [6];
        int A = nums [0];
        int B = nums [1];
        int C = total-A-B;
        System.out.println(A + " " + B + " " + C);
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