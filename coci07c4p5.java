import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] bit;
    static void update(int i, int v){
        for(; i < bit.length; i += i&-i){
            bit [i] = Math.max(bit [i], v);
        }
    }
    static int query(int i){
        int max = 0;
        for(; i > 0; i -= i&-i){
            max = Math.max(max, bit [i]);
        }
        return max;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        pair [] a = new pair [n+1];
        for(int i = 1; i <= n; i++){
            a [i] = new pair(readInt(), readInt());
        }
        Arrays.sort(a, 1, n+1);
        bit = new int [1000001];
        int [] dp = new int [n+1]; int last = 0, max = 0;
        for(int i = 1; i <= n; i++){
            dp [i] = query(a [i].x)+1;
            update(a [i].x, dp [i]);
            if(dp [i] > max){
                max = dp [i]; last = i;
            }
        }
        ArrayList <String> out = new ArrayList(); out.add(a [last].x + " " + a [last].y);
        for(int i = last, j = last-1; j > 0; j--){
            if(dp [i] == dp [j]+1 && a [j].x <= a [i].x && a [j].y >= a [j].y){
                out.add(a [j].x + " " + a [j].y);
                i = j;
            }
        }
        System.out.println(max);
        for(int i = max-1; i >= 0; i--){
            System.out.println(out.get(i));
        }
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