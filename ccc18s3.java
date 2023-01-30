import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int h = readInt(), w = readInt();
        char [][] grid = new char [h][w];
        int [][] dist = new int [h][w];
        for(int i = 0; i < h; i++) {
            grid [i] = next().toCharArray();
            Arrays.fill(dist [i], Integer.MAX_VALUE);
        }
        List <pair> escapes = new ArrayList<>();
        pair src = null;
        boolean camera [][] = new boolean [h][w];
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(grid [i][j] == 'C'){
                    camera [i][j] = true;
                    int cnt = i-1;
                    while(grid [cnt][j] != 'W'){
                        if(grid [cnt][j] == '.') camera [cnt][j] = true;
                        cnt--;
                    }
                    cnt = i+1;
                    while(grid [cnt][j] != 'W'){
                        if(grid [cnt][j] == '.') camera [cnt][j] = true;
                        cnt++;
                    }
                    cnt = j-1;
                    while(grid [i][cnt] != 'W'){
                        if(grid [i][cnt] == '.') camera [i][cnt] = true;
                        cnt--;
                    }
                    cnt = j+1;
                    while(grid [i][cnt] != 'W'){
                        if(grid [i][cnt] == '.') camera [i][cnt] = true;
                        cnt++;
                    }
                }
                else if(grid [i][j] == '.') escapes.add(new pair(i, j));
                else if(grid [i][j] == 'S') {
                    src = new pair(i, j);
                    grid [i][j] = '.';
                }
            }
        }
        dist [src.x][src.y] = 0;
        Queue <pair> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            pair u = q.poll();
            List <pair> moves = moves(grid, camera, u);
            while(!moves.isEmpty()){
                pair e = moves.remove(0);
                int cost = 1;
                if(grid [u.x][u.y] != '.') cost = 0;
                if(dist [e.x][e.y] > dist [u.x][u.y] + cost){
                    dist [e.x][e.y] = dist [u.x][u.y] + cost;
                    q.add(e);
                }
            }
        }
        for(int i = 0; i < escapes.size(); i++){
            pair cur = escapes.get(i);
            System.out.println((dist [cur.x][cur.y] != Integer.MAX_VALUE && !camera [src.x][src.y])? dist [cur.x][cur.y]:-1);
        }
    }
    static List <pair> moves(char [][] grid, boolean [][] camera, pair src){
        int x = src.x, y = src.y;
        List <pair> moves = new ArrayList<>();
        if(grid [x][y] == '.'){
            if(grid [x-1][y] != 'W' && !camera [x-1][y]) moves.add(new pair(x-1, y));
            if(grid [x+1][y] != 'W' && !camera [x+1][y]) moves.add(new pair(x+1, y));
            if(grid [x][y-1] != 'W' && !camera [x][y-1]) moves.add(new pair(x, y-1));
            if(grid [x][y+1] != 'W' && !camera [x][y+1]) moves.add(new pair(x, y+1));
        }
        else if(grid [x][y] == 'D' && grid [x+1][y] != 'W' && !camera [x+1][y]) moves.add(new pair(x+1, y));
        else if(grid [x][y] == 'U' && grid [x-1][y] != 'W' && !camera [x-1][y]) moves.add(new pair(x-1, y));
        else if(grid [x][y] == 'L' && grid [x][y-1] != 'W' && !camera [x][y-1]) moves.add(new pair(x, y-1));
        else if(grid [x][y] == 'R' && grid [x][y+1] != 'W' && !camera [x][y+1]) moves.add(new pair(x, y+1));
        return moves;
    }
    static class pair{
        int x, y;
        public pair(int x, int y) {
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