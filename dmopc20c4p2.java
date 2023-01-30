import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        long n = readLong(), m = readLong(), k = readLong();
        HashSet <Long> col = new HashSet();
        HashSet <Long> row = new HashSet();
        for(int i = 0; i < k; i++){
            long x = readLong(), y = readLong();
            if(row.contains(x)){
                row.remove(x);
            }
            else row.add(x);
            
            if(col.contains(y)){
                col.remove(y);
            }
            else col.add(y);
        }
        int ans = 0;
        Queue <Long> cols = new LinkedList();
        for(Long x : col) cols.add(x);
        List <pair> out = new ArrayList();
        for(Long r : row){
            long x = r, y;
            if(cols.isEmpty()){
                y = 1;
                cols.add(y);
            }
            else{
                y = cols.poll();
            }
            ans++;
            out.add(new pair(x, y));
        }
        col.clear();
        col.addAll(cols);
        Queue <Long> rows = new LinkedList();
        for(Long c : col){
            long y = c, x;
            if(rows.isEmpty()){
               x = 1;
               rows.add(x);
            }
            else{
                x = rows.poll();
            }
            ans++;
            out.add(new pair(x, y));
        }
        System.out.println(ans);
        for(pair p : out){
            System.out.println(p.x + " " + p.y);
        }
    }
    static class pair{
        long x, y;
        public pair(long a, long b){
            x = a;
            y = b;
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