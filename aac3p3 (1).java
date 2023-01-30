import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] a = new int [n];
        for(int i = 0; i < n; i++){
            a [i] = readInt();
        }
        Arrays.sort(a);
        boolean same = true;
        for(int i = 1; i < n; i++){
            if(a [i] != a [i-1]) same = false;
        }
        if(same || n == 1){
            for(int i = 0; i < n; i++){
                System.out.print(a [i] + (i != n-1? " " : "\n"));
            }
            for(int i = 0; i < n; i++){
                System.out.print("E");
            }
            System.out.println();
            return;
        }
        int [] b = new int [n];
        for(int i = 0; i < n/2; i++){
            b [i*2] = a [i];
            b [1+i*2] = a [n-i-1];
        }
        if(n%2 == 1){
            b [n-1] = a [n/2];
        }
        for(int i = 0; i < n; i++){
            System.out.print(b [i] + (i != n-1? " " : "\n"));
        }
        for(int i = 0; i < n/2; i++){
            System.out.print("BS");
        }
        if(n%2 == 1){
            System.out.println("E");
        }
        else System.out.println("");
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