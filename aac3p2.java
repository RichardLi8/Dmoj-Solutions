import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int k = readInt(), d = readInt();
        int [] a = new int [d];
        for(int i = 0; i < d; i++){
            a [i] = readInt();
        }
        Arrays.sort(a);
        int digit = -1;
        boolean zero = false;
        for(int i = 0; i < d; i++){
            if(digit == -1 && a [i] != 0) {
                digit = a [i];
            }
            if(a [i] == 0) zero = true;
        }
        if(digit == -1){
            System.out.println(-1);
        }
        else if(zero){
            if(k <= 2){
                for(int i = 0; i < k; i++){
                    System.out.print(digit);
                }
                System.out.println();
            }
            else{
                System.out.print(digit);
                for(int i = 0; i < k-2; i++){
                    System.out.print(0);
                }
                System.out.println(digit);
            }
        }
        else{
            for(int i = 0; i < k; i++){
                System.out.print(digit);
            }
            System.out.println();
        }
    }
    static class pair{
        long v; int i;
        pair(long a, int b){
            v = a;
            i = b;
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