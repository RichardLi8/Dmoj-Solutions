import java.io.*;
import java.util.*;

public class HelloWorld {
    static ArrayList <Integer> routes [];
    static int sets [];
    static int set = 1;
    public static void main(String args[])throws IOException{
        int n = readInt(), m = readInt(), k = readInt();
        String [] planets = next().split("");
        routes = new ArrayList [n+1];
        for(int i = 1; i <= n; i++) routes [i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int x = readInt();
            int y = readInt();
            if(planets [x-1].equals(planets [y-1])){
                routes [x].add(y);
                routes [y].add(x);
            }
        }
        sets = new int [n+1];
        for(int i = 1; i <= n; i++){
            if(sets [i] == 0){
                BFS(i);
                set++;
            }
        }
        int ans = 0;
        for(int i = 0; i < k; i++){
            int x = readInt(), y = readInt();
            if(sets [x] == sets [y]) ans++;
        }
        System.out.println(ans);
    }
    public static void BFS(int src){
        sets [src] = set;
        Queue <Integer> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int i : routes[u]){
                if(sets [i] == 0){
                    sets [i] = set;
                    queue.add(i);
                }
            }
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