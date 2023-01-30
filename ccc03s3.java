import java.io.*;
import java.util.*;

public class HelloWorld {
    static boolean visited [][];
    static List <Integer> areas = new ArrayList();
    static char [][] grid;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int h = readInt();
        int w = readInt();
        visited = new boolean [h][w];
        grid = new char [h][w];
        for(int i = 0; i < h; i++){
            grid [i] = next().toCharArray();
        }
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(grid [i][j] != 'I' && !visited [i][j]){
                    BFS(new edge(i, j));
                }
            }
        }
        Collections.sort(areas, Collections.reverseOrder());
        int ans = 0;
        while(!areas.isEmpty()){
            int cur = areas.remove(0);
            if(n-cur >= 0){
                ans++;
                n-=cur;
            }
            else break;
        }
        if(ans == 1) System.out.println(ans + " room, " + n + " square metre(s) left over");
        else System.out.println(ans + " rooms, " + n + " square metre(s) left over");
    }
    static void BFS(edge src){
        Queue <edge> q = new LinkedList();
        visited [src.x][src.y] = true;
        q.add(src);
        int count = 1;
        while(!q.isEmpty()){
            int x = q.peek().x, y = q.poll().y;
            if(x-1 >= 0 && grid [x-1][y] != 'I' && !visited [x-1][y]){
                q.add(new edge(x-1, y));
                visited [x-1][y] = true;
                count++;
            }
            if(x+1 < grid.length && grid [x+1][y] != 'I' && !visited [x+1][y]){
                q.add(new edge(x+1, y));
                visited [x+1][y] = true;
                count++;
            }
            if(y-1 >= 0 && grid [x][y-1] != 'I' && !visited [x][y-1]){
                q.add(new edge(x, y-1));
                visited [x][y-1] = true;
                count++;
            }
            if(y+1 < grid[0].length && grid [x][y+1] != 'I' && !visited [x][y+1]){
                q.add(new edge(x, y+1));
                visited [x][y+1] = true;
                count++;
            }
        }
        areas.add(count);
    }
    static class edge{
        int x, y;
        public edge(int x, int y){
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
}