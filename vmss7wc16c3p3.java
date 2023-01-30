import java.io.*;
import java.util.*;

public class HelloWorld {
    static int roads [][];
    public static void main(String args[])throws IOException{
        int n = readInt();
        int m = readInt();
        int goal = readInt();
        int q = readInt();
        roads = new int [n+1][n+1];
        for(int i = 0; i < m; i++){
            int x = readInt();
            int y = readInt();
            int cost = readInt();
            roads [x][y] = cost;
            roads [y][x] = cost;
        }
        paths(goal);
        for(int i = 0; i < q; i++){
            int src = readInt();
            if(dist [src] != Integer.MAX_VALUE) System.out.println(dist [src]);
            else System.out.println(-1);
        }
    }
    public static int minIndex(int dist [], boolean visited []){
        int index = -1;
        int smallest = Integer.MAX_VALUE;
        for(int i = 1; i < dist.length; i++){
            if(!visited [i] && dist [i] < smallest){
                index = i;
                smallest = dist [i];
            }
        }
        return index;
    }
    static int dist [];
    public static void paths(int src){
        boolean visited [] = new boolean [roads.length];
        dist = new int [roads.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist [src] = 0;
        int u = minIndex(dist, visited);
        while(u != -1){
            visited [u] = true;
            for(int i = 1; i < roads.length; i++){
                if(roads [u][i] > 0 && !visited[i] && dist [i] > dist [u] + roads [u][i]){
                    dist [i] = dist [u] + roads [u][i];
                }
            }
            u = minIndex(dist, visited);
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
}