import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int h = readInt(), w = readInt(), k = readInt();
        int [][] maxg = new int [h][w-k+1], ming = new int [h][w-k+1];
        for(int i = 0; i < h; i++){
            Deque <pair> min = new ArrayDeque(), max = new ArrayDeque();
            for(int j = 0; j < w; j++){
                int v = readInt();
                if(!min.isEmpty() && min.peekFirst().i <= j-k) min.pollFirst();
                while(!min.isEmpty() && min.peekLast().v >= v) min.pollLast();
                if(!max.isEmpty() && max.peekFirst().i <= j-k) max.pollFirst();
                while(!max.isEmpty() && max.peekLast().v <= v) max.pollLast();
                max.add(new pair(v, j)); min.add(new pair(v, j));
                if(j < k-1) continue;
                maxg [i][j-k+1] = max.peekFirst().v;
                ming [i][j-k+1] = min.peekFirst().v;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < w-k+1; j++){
            Deque <pair> min = new ArrayDeque(), max = new ArrayDeque();
            for(int i = 0; i < h; i++){
                if(!min.isEmpty() && min.peekFirst().i <= i-k) min.pollFirst();
                while(!min.isEmpty() && min.peekLast().v > ming [i][j]) min.pollLast();
                if(!max.isEmpty() && max.peekFirst().i <= i-k) max.pollFirst();
                while(!max.isEmpty() && max.peekLast().v <= maxg [i][j]) max.pollLast();
                max.addLast(new pair(maxg [i][j], i));
                min.addLast(new pair(ming [i][j], i));
                if(i < k-1) continue;
                ans = Math.min(ans, max.peekFirst().v-min.peekFirst().v);
            }
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return 0;
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
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
}