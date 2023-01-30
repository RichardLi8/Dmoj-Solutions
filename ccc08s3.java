import java.io.*;
import java.util.*;

public class HelloWorld {
    static int w, h;
    public static void main(String [] args) throws IOException{
        int t = readInt();
        for(int a = 0; a < t; a++){
            h = readInt(); w = readInt();
            char [][] grid = new char [h][w];
            for(int i = 0; i < h; i++){
                grid [i] = next().toCharArray();
            }
            System.out.println(sp(grid, h, w));
        }
    }
    static int sp(char [][] grid, int h, int w){
        int [][] dist = new int [h][w];
        for(int i = 0; i < h; i++){
            Arrays.fill(dist [i], Integer.MAX_VALUE);
        }
        Queue <pair> q = new LinkedList();
        dist [0][0] = 1;
        q.add(new pair(0, 0));
        while(!q.isEmpty()){
            int x = q.peek().x, y = q.poll().y;
            List <pair> moves = moves(x, y, grid);
            for(pair p : moves){
                if(dist [p.x][p.y] > dist [x][y]+1){
                    dist [p.x][p.y] = dist [x][y]+1;
                    q.add(new pair(p.x, p.y));
                }
            }
        }
        return dist [h-1][w-1] == Integer.MAX_VALUE?-1:dist[h-1][w-1];
    }
    static List <pair> moves(int x, int y, char [][] grid){
        List <pair> moves = new ArrayList();
        if(grid [x][y] == '+'){
            if(x > 0 && grid [x-1][y] != '*') moves.add(new pair(x-1, y));
            if(x < h-1 && grid [x+1][y] != '*') moves.add(new pair(x+1, y));
            if(y > 0 && grid [x][y-1] != '*') moves.add(new pair(x, y-1));
            if(y < w-1 && grid [x][y+1] != '*') moves.add(new pair(x, y+1));
        }
        else if(grid [x][y] == '-'){
            if(y > 0 && grid [x][y-1] != '*') moves.add(new pair(x, y-1));
            if(y < w-1 && grid [x][y+1] != '*') moves.add(new pair(x, y+1));
        }
        else if(grid [x][y] == '|'){
            if(x > 0 && grid [x-1][y] != '*') moves.add(new pair(x-1, y));
            if(x < h-1 && grid [x+1][y] != '*') moves.add(new pair(x+1, y));
        }
        return moves;
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