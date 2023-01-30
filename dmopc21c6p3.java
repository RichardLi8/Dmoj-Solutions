import java.io.*;
import java.util.*;
public class HelloWorld {
    static boolean check(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    static int n, m, dr [] = {1, 0, -1, 0}, dc [] = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        n = readInt(); m = readInt(); int k = readInt();
        int [][] g = new int [n][m], dist = new int [n][m];
        Queue <pair> q = new ArrayDeque();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                g [i][j] = readInt();
                if(g [i][j] == 0){
                    g [i][j] = Integer.MAX_VALUE;
                    dist [i][j] = Integer.MAX_VALUE;
                }
                else{
                    q.add(new pair(i, j));
                }
            }
        }
        while(!q.isEmpty()){
            int x = q.peek().v, y = q.poll().i;
            for(int i = 0; i < 4; i++){
                int nx = x + dr [i], ny = y + dc [i];
                if(!check(nx, ny)) continue;
                if(dist [x][y] == k) continue;
                if(dist [nx][ny] > dist [x][y] + 1){
                    q.add(new pair(nx, ny));
                    dist [nx][ny] = dist [x][y] + 1;
                    g [nx][ny] = g [x][y];
                }
                else if(dist [nx][ny] == dist [x][y]+1 && g [nx][ny] > g [x][y]){
                    q.add(new pair(nx, ny));
                    dist [nx][ny] = dist [x][y] + 1;
                    g [nx][ny] = g [x][y];
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(g [i][j] == Integer.MAX_VALUE) g [i][j] = 0;
                System.out.print(g [i][j] + (j != m-1? " " : "\n"));
            }
        }
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return 0;
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}