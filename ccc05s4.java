import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int l = readInt();
        for(int k = 0; k < l; k++){
            int n = readInt();
            List <Integer> adj [] = new ArrayList [100];
            for(int i = 0; i < 100; i++) adj [i] = new ArrayList();
            Map <String, Integer> names = new HashMap();
            String first = next();
            int count = 0;
            for(int i = 0; i < n-1; i++){
                String second = next();
                if(!names.containsKey(first)){
                    names.put(first, count);
                    count++;
                }
                if(!names.containsKey(second)){
                    names.put(second, count);
                    count++;
                }
                int x = names.get(first);
                int y = names.get(second);
                adj [x].add(y);
                adj [y].add(x);
                first = second;
            }
            ans(names.get(first), adj, count);
            System.out.println((count-1)*20-ans(names.get(first), adj, count));
        }
    }
    static int ans(int src, List <Integer> adj [], int size){
        int [] dist = new int [size];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist [src] = 0;
        Queue <Integer> q = new LinkedList();
        q.add(src);
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj [u]){
                if(dist [v] > dist [u] + 20){
                    dist [v] = dist [u] + 20;
                    q.add(v);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < size; i++){
            ans = Math.max(dist [i], ans);
        }
        return ans;
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