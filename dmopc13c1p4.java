import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
    public static void main(String [] args) throws IOException{
        int n = readInt();
        for(int m = 0; m < n; m++){
            int c = readInt(), r = readInt();
            int xs = 0, ys = 0, xe = 0, ye = 0;
            char [][] g = new char [r+2][c+2];
            int [][] dist = new int [r+2][c+2];
            for(int i = 1; i <= r; i++){
                String s = br.readLine();
                for(int j = 1; j <= c; j++){
                    dist [i][j] = Integer.MAX_VALUE;
                    char x = s.charAt(j-1);
                    g [i][j] = x;
                    if(x == 'C'){
                        xs = i; ys = j;
                    }
                    else if(x == 'W'){
                        xe = i; ye = j;
                    }
                }
            }
            dist [xs][ys] = 0;
            Queue <pair> q = new LinkedList();
            q.add(new pair(xs, ys));
            while(!q.isEmpty()){
                int x = q.peek().x, y = q.poll().y;
                if(g [x][y] == 'O' || g [x][y] == 'C'){
                    for(int i = 0; i < 4; i++){
                        int nx = x + dr [i], ny = y + dc [i];
                        if(dist [nx][ny] > dist [x][y] + 1){
                            dist [nx][ny] = dist [x][y]+1;
                            q.add(new pair(nx, ny));
                        }
                    }
                }
            }
            System.out.println(dist [xe][ye] < 60? dist [xe][ye] : "#notworth");
        }
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