import java.io.*;
import java.util.*;
public class HelloWorld {
    static void update(int r, int c, int v){
        for(int i = r; i < bit.length; i += i&-i){
            for(int j = c; j < bit [0].length; j += j&-j){
                bit [i][j] += v;
            }
        }
    }
    static int query(int r, int c){
        int sum = 0;
        for(int i = r; i > 0; i -= i&-i){
            for(int j = c; j > 0; j -= j&-j){
                sum += bit [i][j];
            }
        }
        return sum;
    }
    static int bit [][];
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        bit = new int [n+1][m+1]; int [][] grid = new int [n+1][m+1];
        int o;
        while((o = readInt()) != 0){
            if(o == 1){
                int r = readInt(), c = readInt(), x = readInt();
                if((r+c)%2 == 0){
                    update(r, c, x-grid [r][c]);
                    grid [r][c] = x;
                }
                else{
                    update(r, c, -x-grid [r][c]);
                    grid [r][c] = -x;
                }
            }
            else{
                int r1 = readInt(), c1 = readInt(), r2 = readInt(), c2 = readInt();
                int ans = query(r2, c2)-query(r1-1, c2)-query(r2, c1-1)+query(r1-1, c1-1);
                if((r1+c1)%2 == 1) ans = -ans;
                System.out.println(ans);
            }
        }
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return Long.compare(v, p.v);
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