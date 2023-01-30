import java.io.*;
import java.util.*;
public class HelloWorld {
    static boolean check(int x, int y){
        if(x >= 0 && x < n && y >= 0 && y < m) return true;
        return false;
    }
    static void dij(boolean g [][]){
        PriorityQueue <triple> pq = new PriorityQueue();
        for(int j = 0; j < m; j++){
            if(!g [0][j]) continue;
            pq.add(new triple(0, j, Integer.MAX_VALUE));
            size [0][j] = Integer.MAX_VALUE;
        }
        while(!pq.isEmpty()){
            triple t = pq.poll();
            int x = t.x, y = t.y;
            if(t.d < size [x][y]) continue;
            for(int i = 0; i < 4; i++){
                int newx = x + dr [i], newy = y + dc [i];
                if(check(newx, newy) && g [newx][newy] && size [x][y] > size [newx][newy]){
                    size [newx][newy] = size [x][y];
                    pq.add(new triple(newx, newy, size [newx][newy]));
                }
                else if(check(newx, newy) && !g [newx][newy]){
                    while(check(newx+dr[i], newy+dc[i]) && !g [newx+=dr[i]][newy+=dc[i]]);
                    if(!g [newx][newy])continue;
                    int dist;
                    if(dr [i] == 0){
                        dist = Math.min(size [x][y], Math.abs(y-newy)-1);
                    }
                    else{
                        dist = Math.min(size [x][y], Math.abs(x-newx)-1);
                    }
                    if(dist > size [newx][newy]){
                        size [newx][newy] = dist;
                        pq.add(new triple(newx, newy, size [newx][newy]));
                    }
                }
            }
        }
    }
    static int n, m;
    static int [][] size;
    static int [] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
    public static void main(String [] args) throws IOException{
        n = readInt(); m = readInt();
        boolean [][] g = new boolean [n][m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                g [i][j] = s.charAt(j) == '#';
            }
        }
        size = new int [n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                size [i][j] = -1;
            }
        }
        dij(g);
        for(int j = 0; j < m; j++){
            System.out.print((size [n-1][j] == Integer.MAX_VALUE? 0 : size [n-1][j]) + (j != m-1 ? " " : "\n"));
        }
    }
    static class triple implements Comparable <triple>{
        int x, y, d;
        triple(int a, int b, int c){
            x = a;
            y = b;
            d = c;
        }
        public int compareTo(triple t){
            return -Integer.compare(d, t.d);
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