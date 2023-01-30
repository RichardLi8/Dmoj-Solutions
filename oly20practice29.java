import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String args[])throws IOException{
        int n = readInt(), m = readInt(), k = readInt();
        int [][] graph = new int [n+1][n+1];
        for(int i = 1; i <=n ; i++){
            for(int j = 1; j <= n; j++){
                graph [i][j] = (int) 1e9;
            }
        }
        for(int i = 0; i < m; i++){
            graph [readInt()][readInt()] = readInt();
        }
        for(int a = 1; a <= n; a++)
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++)
                    graph [i][j] = Math.min(graph [i][j], Math.max(graph [i][a], graph [a][j]));
        for(int i = 0; i < k; i++){
            int q = graph [readInt()][readInt()];
            if(q != (int)1e9) System.out.println(q);
            else System.out.println(-1);
        }
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
}