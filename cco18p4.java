import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int r = readInt(), c = readInt(), k = readInt();
        int low1 = 1, high1 = r;
        int low2 = 1, high2 = c;
        while(low1 < high1 || low2 < high2){
            int mid1 = (high1+low1)/2;
            int mid2 = (high2+low2)/2;
            System.out.println("? " + mid1 + " " + mid2);
            int cur = readInt();
            if(low1 < high1){
                System.out.println("? " + (mid1+1) + " " + mid2);
                int r1 = readInt();
                if(r1 < cur){
                    low1 = mid1+1;
                }
                else high1 = mid1;
            }
            if(low2 < high2){
                System.out.println("? " + mid1 + " " + (mid2+1));
                int c1 = readInt();
                if(c1 < cur){
                    low2 = mid2+1;
                }
                else high2 = mid2;
            }
        }
        System.out.println("? " + low1 + " " + low2);
        System.out.println("! " + readInt());
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
}