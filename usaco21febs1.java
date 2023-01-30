import java.io.*;
import java.util.*;

public class HelloWorld {
    static boolean [][] grid = new boolean [4000][4000];
    public static void main(String[] args) throws IOException {
        int n = readInt(), cows = 0;
        for(int i = 1; i <= n; i++){
            pair cur = new pair(readInt()+2000, readInt()+2000);
            Queue <pair> q = new LinkedList();
            q.add(cur);
            while(!q.isEmpty()){
                int x = q.peek().x, y = q.poll().y;
                if(!grid [x][y]){
                    cows++;
                    grid [x][y] = true;
                    q.addAll(changed(x, y));
                }
            }
            System.out.println(cows-i);
        }
    }
    static List <pair> changed(int x, int y){
        List <pair> comfy = new ArrayList();
        if(isComfy(x+1, y) && grid [x+1][y]) comfy.add(find(x+1, y));
        if(isComfy(x-1, y) && grid [x-1][y]) comfy.add(find(x-1, y));
        if(isComfy(x, y+1) && grid [x][y+1]) comfy.add(find(x, y+1));
        if(isComfy(x, y-1) && grid [x][y-1]) comfy.add(find(x, y-1));
        if(isComfy(x, y)) comfy.add(find(x, y));
        return comfy;
    }
    static pair find(int x, int y){
        if(!grid [x+1][y]) return new pair(x+1, y);
        if(!grid [x-1][y]) return new pair(x-1, y);
        if(!grid [x][y+1]) return new pair(x, y+1);
        if(!grid [x][y-1]) return new pair(x, y-1);
        return null;
    }
    static boolean isComfy(int x, int y){
        int cnt = 0;
        if(grid [x+1][y]) cnt++;
        if(grid [x-1][y]) cnt++;
        if(grid [x][y+1]) cnt++;
        if(grid [x][y-1]) cnt++;
        return cnt == 3;
    }
    static class pair{
        int x, y;
        public pair(int x, int y){
            this.x = x;
            this.y = y;
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