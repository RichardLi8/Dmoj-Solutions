import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String args[])throws IOException{
        int n = readInt();
        ArrayList <Integer> [] roads = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) roads [i] = new ArrayList<>();
        for(int i = 0; i < n-1; i++){
            int x = readInt();
            int y = readInt();
            roads [x].add(y);
            roads [y].add(x);
        }
        System.out.println(BFS(roads, n));
    }
    public static int BFS(ArrayList <Integer> roads [], int size){
        Queue <Integer> queue = new LinkedList<>();
        boolean visited [] = new boolean [size+1];
        queue.add(1);
        visited [1] = true;
        int ans = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            int count = 0;
            for(int i = 0; i < roads [u].size(); i++){
                if(!visited [roads [u].get(i)]){
                    queue.add(roads [u].get(i));
                    visited [roads[u].get(i)] = true;
                    ans++;
                    count++;
                }
            }
            ans += wait(count);
        }
        return ans;
    }
    public static int wait(int needed){
        int start = 0;
        while(Math.pow(2, start) <= needed) start++;
        return start;
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