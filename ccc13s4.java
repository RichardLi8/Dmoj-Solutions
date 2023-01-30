import java.io.*;
import java.util.*;

public class HelloWorld {
    static List <Integer> [] graph;
    public static void main(String args[])throws IOException{
        int n = readInt();
        int m = readInt();
        graph = new ArrayList [n+1];
        for(int i = 0; i < m; i++){
            int a = readInt();
            int b = readInt();
            if(graph [a] == null) graph [a] = new ArrayList<>();
            graph [a].add(b);
        }
        int p = readInt();
        int q = readInt();
        if(BFS(p, q)) System.out.println("yes");
        else if(BFS(q, p)) System.out.println("no");
        else System.out.println("unknown");
    }
    public static boolean BFS(int src, int goal){
        boolean visited [] = new boolean [graph.length];
        visited [src] = true;
        Queue <Integer> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()){
            int u = queue.poll();
            if(graph [u] != null){
                for(int i = 0; i < graph [u].size(); i++){
                    int cur = graph [u].get(i);
                    if(!visited [cur]) {
                        queue.add(cur);
                        visited [cur] = true;
                        if(cur == goal) return true;
                    }
                }
            }
        }
        return false;
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