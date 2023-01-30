import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        for(int t = readInt(); t > 0; t--){
            int a = readInt(), b = readInt(), c = readInt();
            if(c == 0 && ((b%2 == 0 && a %2 == 0) || (b%2 == 1 && a%2 == 0 && a > 1))){
                System.out.println("YES");
            }
            else if((a-c)%2 == 0 && a >= c && c >= 1){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return Integer.compare(y, p.y);
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