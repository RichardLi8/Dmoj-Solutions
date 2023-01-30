import java.io.*;
import java.util.*;

public class HelloWorld {
    static List <Integer> adj [];
    static int [] dist;
    public static void main(String [] args) throws IOException{
        int n = readInt(), w = readInt(), d = readInt();
        adj = new ArrayList [n+1];
        for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
        for(int i = 0; i < w; i++){
            int x = readInt(), y = readInt();
            adj [y].add(x);
        }
        int [] stations = new int [n];
        dist = new int [n+1];
        BFS(n);
        for(int i = 0; i < n; i++) stations [i] = readInt();
        TreeSet <Integer> ans = new TreeSet();
        int trains [] = new int [n+1];
        int freq [] = new int [(int)1e6 + 1];
        for(int i = 0; i < n; i++){
            trains [stations [i]] = Math.min((int)1e6 , dist [stations [i]] + i);
            ans.add(trains [stations [i]]);
            freq [trains [stations [i]]]++;
        }
        for(int i = 0; i < d; i++){
            int x = readInt()-1, y = readInt()-1;
            freq [trains [stations [x]]]--; freq [trains [stations [y]]]--;
            if(freq [trains [stations [x]]] == 0) ans.remove(trains [stations [x]]); 
            if(freq [trains [stations [y]]] == 0) ans.remove(trains [stations [y]]);
            trains [stations [x]] = Math.min((int)1e6, dist [stations [x]] + y);
            trains [stations [y]] = Math.min((int)1e6, dist [stations [y]] + x);
            freq [trains [stations [x]]]++; freq [trains [stations [y]]]++;
            ans.add(trains [stations [x]]); ans.add(trains [stations [y]]);
            int temp = stations [x];
            stations [x] = stations [y];
            stations [y] = temp;
            System.out.println(ans.first());
        }
    }
    static void BFS(int n){
        Queue <Integer> q = new LinkedList();
        q.add(n);
        Arrays.fill(dist, (int)1e6);
        dist [n] = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            for(Integer v : adj [u]){
                if(dist [v] > dist [u] + 1){
                    dist [v] = dist [u] + 1;
                    q.add(v);
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
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
}