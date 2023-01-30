import java.io.*;
import java.util.*;
public class HelloWorld {
    static int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt(), max = (int)(Math.log(n)/Math.log(2));
        int [][] dif = new int [17][n+2];
        int [] x = new int [m], y = new int [m], z = new int [m]; 
        for(int i = 0; i < m; i++){
            x [i] = readInt(); y [i] = readInt(); z [i] = readInt();
            dif [z [i]][x [i]]++; dif [z [i]][y [i]+1]--;
        }
        int [][] st = new int [n+1][max+1];
        int [] lcm = new int [n+1];
        for(int j = 1; j <= 16; j++){
            for(int i = 1; i <= n; i++){
                dif [j][i] += dif [j][i-1];
            }
        }
        for(int i = 1; i <= n; i++){
            lcm [i] = 1;
            for(int j = 1; j <= 16; j++){
                if(dif [j][i] >= 1){
                    lcm [i] = (lcm [i] * j)/gcd(lcm [i], j);
                }
            }
            st [i][0] = lcm [i];
        }
        for(int j = 1; j <= max; j++){
            for(int i = 1; i <= n; i++){
                if(i + (1<<j)-1 > n) break;
                st [i][j] = gcd(st [i][j-1], st [i + (1<<j-1)][j-1]);
            }
        }
        boolean ans = true;
        for(int i = 0; i < m; i++){
            int k = (int)(Math.log(y [i]-x [i]+1)/Math.log(2));
            int gcd = gcd(st [x[i]][k], st [y[i]-(1<<k)+1][k]);
            if(gcd != z [i]) ans = false;
        }
        if(ans){
            for(int i = 1; i <= n; i++){
                System.out.print(lcm [i] + " ");
            }
            System.out.println();
        }
        else System.out.println("Impossible");
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            return Integer.compare(w, p.w);
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