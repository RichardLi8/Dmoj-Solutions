import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        List <Integer> connections [] = new ArrayList [10000];
        for(int i = 1; i < 10000; i++) connections [i] = new ArrayList<>();
        for(int i = 0; i < n; i++){
            connections [readInt()].add(readInt());
        }
        int x = readInt(), y = readInt();
        while(x != 0 && y != 0){
            int ans = sp(x, y, connections);
            System.out.println(ans == Integer.MAX_VALUE?"No":"Yes " + (ans-1));
            x = readInt(); y = readInt();
        }
    }
    static int sp(int src, int goal, List <Integer> connections []){
        int [] dist = new int [10000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue <Integer> q = new LinkedList();
        q.add(src);
        dist [src] = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            for(Integer v : connections[u]){
                if(dist [v] > dist [u] + 1){
                    dist [v] = dist [u] + 1;
                    q.add(v);
                }
            }
        }
        return dist [goal];
    }
    static class edge implements Comparable <edge>{
        int v, w;
        public edge(int v, int w){
            this.v = v;
            this.w = w;
        }
        public int compareTo(edge x){
            return -Integer.compare(w, x.w);
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