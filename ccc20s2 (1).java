import java.io.*;
import java.util.*;

public class HelloWorld {
    
    static int h, w;
    static int [][] grid;
    public static void main(String args[])throws IOException{
        h = readInt();
        w = readInt();
        grid = new int [h+1][w+1];
        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= w; j++){
                grid [i][j] = readInt();
            }
        }
        boolean possible = BFS();
        if(possible)System.out.println("yes");
        else System.out.println("no");
    }
    public static boolean BFS(){
        Queue <Integer> queue = new LinkedList<>();
        Set <Integer> visited = new HashSet<>();
        queue.add(grid [1][1]);
        visited.add(grid [1][1]);
        while(!queue.isEmpty()){
            int u = queue.poll();
            List <point> factors = factors(u);
            while(!factors.isEmpty()){
                point cur = factors.remove(0);
                if(cur.x == w && cur.y == h) return true;
                if(!visited.contains(grid [cur.y][cur.x])){
                    visited.add(grid [cur.y][cur.x]);
                    queue.add(grid [cur.y][cur.x]);
                }
            }
        }
        return false;
    }
    
    public static List <point> factors(int n){
        List <point> factors = new LinkedList<>();
        for(int i = 1; i <= h ;i++){
            if(n%i == 0){
                if(n/i <= w)factors.add(new point(n/i, i));
            }
        }
        return factors;
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
class point{
    int x;
    int y;
    public point(int x, int y){
        this.x = x;
        this.y = y;
    }
}