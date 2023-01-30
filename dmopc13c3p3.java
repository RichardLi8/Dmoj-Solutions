import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] dr = {1,0,-1,0}, dc = {0,1,0,-1};
    public static void main(String [] args) throws IOException{
        int n = readInt(), h = readInt();
        int [][] g = new int [n+2][n+2];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                g [i][j] = readInt();
            }
        }
        boolean [][] vis = new boolean [n+2][n+2];
        Queue <pair> q = new LinkedList();
        vis [1][1] = true;
        q.add(new pair(1, 1));
        while(!q.isEmpty()){
            int x = q.peek().x, y = q.poll().y;
            for(int i = 0; i < 4; i++){
                int nx = x + dr [i], ny = y + dc [i];
                if(nx == 0 || ny == 0 || nx == n+1 || ny == n+1) continue;
                if(!vis [nx][ny] && Math.abs(g [nx][ny] - g [x][y]) <= h){
                    vis [nx][ny] = true;
                    q.add(new pair(nx, ny));
                }
            }
        }
        System.out.println(vis [n][n]? "yes" : "no");
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return -Integer.compare(y, p.y);
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