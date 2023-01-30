import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        Map <Integer, Integer> row = new HashMap(), col = new HashMap();
        for(int i = 1; i <= n; i++){
            int x = readInt();
            if(x == -1) continue;
            if(row.containsKey(x-i)){
                row.put(x-i, row.get(x-i)+1);
            }
            else{
                row.put(x-i, 1);
            }
        }
        for(int j = 1; j <= m; j++){
            int y = readInt();
            if(y == -1) continue;
            if(col.containsKey(y-j)){
                col.put(y-j, col.get(y-j)+1);
            }
            else{
                col.put(y-j, 1);
            }
        }
        int ans = 0;
        for(int x : row.keySet()){
            ans += Math.min(row.get(x), col.getOrDefault(x, 0));
        }
        System.out.println(ans);
    }
    static class pair{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
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