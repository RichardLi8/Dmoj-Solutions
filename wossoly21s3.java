import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
    static char [][] g;
    static int n, m;
    static pair [] l, c;
    static long dist(int src){
        Queue <pair> q = new LinkedList();
        boolean [][] inqueue = new boolean [n+2][m+2];
        q.add(c[src]);
        inqueue [c[src].x][c[src].y] = true;
        long [][] dist = new long [n+2][m+2];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dist [i][j] = Long.MAX_VALUE;
            }
        }
        dist [c[src].x][c[src].y] = 0;
        while(!q.isEmpty()){
            int x = q.peek().x, y = q.poll().y;
            inqueue [x][y] = false;
            for(int i = 0; i < 4; i++){
                int nx = x + dr [i], ny = y + dc [i];
                if(g [nx][ny] == '#');
                else if(Character.isUpperCase(g[nx][ny])){
                    pair p = l[g[nx][ny]-'A'];
                    nx = p.x; ny = p.y;
                    if(dist [nx][ny] > dist [x][y] + 1){
                        dist [nx][ny] = dist [x][y] + 1;
                        if(!inqueue [nx][ny]){
                            q.add(new pair(nx, ny));
                            inqueue [nx][ny] = true;
                        }
                    }
                }
                else if(!Character.isLowerCase(g [nx][ny]) && g [nx][ny] != 0 && dist [nx][ny] > dist [x][y] + 1){
                    dist [nx][ny] = dist [x][y]+1;
                    if(!inqueue [nx][ny]){
                        q.add(new pair(nx, ny));
                        inqueue [nx][ny] = true;
                    }
                }
            }
        }
        return dist [c[src+1].x][c[src+1].y];
    }
    public static void main(String [] args) throws IOException{
        n = readInt(); m = readInt();
        g = new char [n+2][m+2];
        c = new pair [5]; l = new pair [26];
        for(int i = 1; i <= n; i++){
            String s = readLine();
            for(int j = 1; j <= m; j++){
                g [i][j] = s.charAt(j-1);
                if(Character.isDigit(g [i][j])){
                    c [g [i][j]-'0'] = new pair(i, j);
                }
                else if(Character.isLowerCase(g [i][j])){
                    l [g [i][j]-'a'] = new pair(i, j);
                }
            }
        }
        long dist = 0;
        for(int i = 0; i < 4; i++){
            long cur = dist(i);
            if(cur == Long.MAX_VALUE){
                System.out.println(-1);
                return;
            }
            dist += cur;
        }
        System.out.println(dist);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Integer.compare(y, p.y);
            return Integer.compare(x, p.x);
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