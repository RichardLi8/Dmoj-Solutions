import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        for(int q = readInt(); q > 0; q--){
            int n = readInt(), m = readInt();
            char [][] grid = new char [n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    grid [i][j] = next().charAt(0);
                }
            }
            int [] h = new int [m];
            int ans = 0;
            Deque <pair> stk = new LinkedList();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(grid [i][j] == 'F') h[j]++;
                    else h [j] = 0;
                    int offset = j;
                    while(!stk.isEmpty() && stk.peekLast().h > h [j]){
                        offset = stk.peekLast().i;
                        ans = Math.max(ans, (j-offset) * stk.pollLast().h);
                    }
                    stk.add(new pair(h [j], offset));
                }
                while(!stk.isEmpty()){
                    ans = Math.max(ans, (m-stk.peekLast().i) * stk.pollLast().h);
                }
            }
            System.out.println(ans*3);
        }
    }
    static class pair{
        int h, i;
        pair(int a, int b){
            h = a;
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