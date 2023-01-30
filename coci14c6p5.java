import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        int [][] a = new int [n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a [i][j] = readInt();
            }
        }
        boolean [][] b = new boolean [n-1][m-1];
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < m-1; j++){
                if(a [i][j] + a [i+1][j+1] <= a [i][j+1] + a [i+1][j]){
                    b [i][j] = true;
                }
            }
        }
        long ans = 0;
        int [] heights = new int [m-1];
        Deque <pair> stk = new LinkedList();
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < m-1; j++){
                if(b [i][j]) heights [j]++;
                else heights [j] = 0;
            }
            for(int j = 0; j < m-1; j++){
                int offset = j;
                while(!stk.isEmpty() && stk.peekLast().v > heights [j]){
                    offset = stk.peekLast().i;
                    ans = Math.max(ans, (j-stk.peekLast().i+1) * (stk.pollLast().v+1));
                }
                stk.add(new pair(heights [j], offset));
            }
            while(!stk.isEmpty()){
                ans = Math.max(ans, (m-stk.peekLast().i) * (stk.pollLast().v+1));
            }
        }
        System.out.println(ans);
    }
    static class pair{
        int v, i;
        pair(int a, int b){
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