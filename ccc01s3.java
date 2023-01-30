import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        String s = next();
        boolean [][] paths = new boolean [26][26];
        List <String> edges = new ArrayList<>();
        while(!s.equals("**")){
            paths [s.charAt(0)- 'A'][s.charAt(1)-'A'] = true;
            paths [s.charAt(1)- 'A'][s.charAt(0)-'A'] = true;
            edges.add(s);
            s = next();
        }
        int count = 0;
        for(int i = 0; i < edges.size(); i++){
            String cur = edges.get(i);
            paths [cur.charAt(0)-'A'][cur.charAt(1)-'A'] = false;
            paths [cur.charAt(1)-'A'][cur.charAt(0)-'A'] = false;
            if(BFS(paths)){
                System.out.println(edges.get(i));
                count++;
            }
            paths [cur.charAt(0)-'A'][cur.charAt(1)-'A'] = true;
            paths [cur.charAt(1)-'A'][cur.charAt(0)-'A'] = true;
        }
        System.out.println("There are " + count + " disconnecting roads.");
    }
    static boolean BFS(boolean [][] paths){
        boolean visited [] = new boolean [26];
        Queue <Integer> q = new LinkedList();
        q.add(0);
        visited [0] = true;
        while(!q.isEmpty()){
            int u = q.poll();
            for(int i = 0; i < 26; i++){
                if(paths [u][i] && !visited [i]){
                    q.add(i);
                    visited [i] = true;
                }
            }
        }
        return visited [1]?false:true;
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