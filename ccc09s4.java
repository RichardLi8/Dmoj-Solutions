import java.io.*;
import java.util.*;

public class HelloWorld {
    static int routes [][];
    static int [] dist;
    public static void main(String args[])throws IOException{
        int n = readInt();
        int t = readInt();
        routes = new int [n+1][n+1];
        for(int i = 0; i < t; i++){
            int x = readInt();
            int y = readInt();
            int cost = readInt();
            routes [x][y] = cost;
            routes [y][x] = cost;
        }
        int k = readInt();
        ArrayList <Integer> stores = new ArrayList<>();
        ArrayList <Integer> pencils = new ArrayList<>();
        for(int i = 0; i < k; i++){
            stores.add(readInt());
            pencils.add(readInt());
        }
        paths(readInt());
        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            if(dist [stores.get(i)] + pencils.get(i) < smallest) smallest = dist [stores.get(i)] + pencils.get(i);
        }
        System.out.println(smallest);
    }
    public static int minIndex(int dist [], boolean visited []){
        int index = -1;
        int smallest = (int)2e6;
        for(int i = 1; i < dist.length; i++){
            if(!visited [i] && dist [i] < smallest){
                index = i;
                smallest = dist [i];
            }
        }
        return index;
    }
    public static void paths(int src){
        boolean visited [] = new boolean [routes.length];
        dist = new int [routes.length];
        Arrays.fill(dist, (int)2e6);
        dist [src] = 0;
        int u = minIndex(dist, visited);
        while(u != -1){
            visited [u] = true;
            for(int i = 1; i < routes.length; i++){
                if(routes [u][i] > 0 && dist [i] > dist [u] + routes [u][i]){
                    dist [i] = dist [u] + routes [u][i];
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