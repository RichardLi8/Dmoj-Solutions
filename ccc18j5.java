import java.io.*;
import java.util.*;

public class HelloWorld {
    static boolean [][] book;
    static Set <Integer> end = new HashSet<>();
    public static void main(String args[])throws IOException{
        int n = readInt();
        book = new boolean [n+1][n+1];
        for(int i = 1; i <= n; i++){
            int m = readInt();
            if(m == 0)end.add(i);
            for(int j = 0; j < m; j++){
                book [i][readInt()] = true;
            }
        }
        if(BFS() == n) System.out.println("Y");
        else System.out.println("N");
        System.out.println(ans);
    }
    static int ans = Integer.MAX_VALUE;
    public static int BFS(){
        Queue <Integer> queue = new LinkedList<>();
        int dist [] = new int [book.length];
        dist [1] = 1;
        queue.add(1);
        int count = 1;
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int i = 1; i < book.length; i++){
                if(book [u][i] && dist [i] == 0){
                    count++;
                    dist [i] = dist [u]+1;
                    queue.add(i);
                }
            }
        }
        for(int i : end){
            if(dist [i] != 0   && dist[i] < ans) ans = dist[i];
        }
        return count;
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