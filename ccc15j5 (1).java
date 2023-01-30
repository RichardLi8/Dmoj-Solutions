import java.io.*;
import java.util.*;

public class HelloWorld {
    static int [][][] visited = new int [251][251][251];
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt();
        System.out.println(solve(n, k, 1));
    }
    public static int solve(int n, int k, int min){
        if(n == k) return 1;
        if(k == 1) return 1;
        if(visited [n][k][min] != 0) return visited [n][k][min];
        int ans = 0;
        for(int i = min; i <= n/k; i++){
            ans += solve(n-i, k-1, i);
        }
        visited [n][k][min] = ans;
        return ans;
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}