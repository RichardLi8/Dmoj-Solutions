import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
            int n = readInt(), p = readInt();
            int ans = 0;
            TreeSet <Integer> set = new TreeSet();
            for(int i = 1; i <= n; i++) set.add(i);
            for(int i = 0; i < p; i++) {
                Integer num = set.lower(readInt()+1);
                if(num == null){
                    System.out.println(ans);
                    return;
                }
                set.remove(num);
                ans++;
            }
            System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(y != p.y) return -Integer.compare(y, p.y);
            return Integer.compare(x, p.x);
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