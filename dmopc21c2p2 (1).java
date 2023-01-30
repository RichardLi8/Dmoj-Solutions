import java.io.*;
import java.util.*;
public class HelloWorld {
    static void swap(int x, int y, int [] a){
        int temp = a [x];
        a [x] = a [y];
        a [y] = temp;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        int [] idx = new int [n+1], last = new int [n+1];
        for(int i = 1; i <= n; i++){
            idx [i] = i; last [i] = i;
        }
        for(int i = 0; i < q; i++){
            char c = next().charAt(0);
            if(c == 'B'){
                int x = readInt(), y = readInt();
                swap(x, y, idx);
                swap(idx [x], idx [y], last);
            }
            else if(c == 'E'){
                int x = readInt(), y = readInt();
                swap(x, y, last);
                swap (last [x], last [y], idx);
            }
            else{
                int [] a = new int [n+1];
                for(int j = 1; j <= n; j++){
                    a [last [j]] = readInt();
                }
                for(int j = 1; j <= n; j++){
                    System.out.print(a [j] + (j != n? " " : "\n"));
                }
            }
        }
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            return Integer.compare(w, p.w);
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