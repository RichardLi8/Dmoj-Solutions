import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int k = readInt();
        ArrayList <Integer> friends = new ArrayList();
        for(int i = 1; i <= k; i++){
                friends.add(i);
        }
        int m = readInt();
        for(int i = 0; i < m; i++){
            int r = readInt();
            ArrayList <Integer> stays = new ArrayList();
            for(int j = 0; j < friends.size(); j++){
                if((j+1)%r != 0){
                    stays.add(friends.get(j));
                }
            }
            friends = stays;
        }
        for(int friend: friends){
            System.out.println(friend);
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(y == p.y) return -Integer.compare(x, p.x);
            return -Integer.compare(y, p.y);
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