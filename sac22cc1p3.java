import java.io.*;
import java.util.*;
public class HelloWorld {
    static void update(char [][] g, int n, int m){
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    if(g [i][j] == 'W'){
                        int cur = j-1;
                        while(cur > 0){
                            if(g [i][cur] == '.'){
                                g [i][cur] = 'W';
                                g [i][cur+1] = '.';
                                flag = true;
                            }
                            else break;
                            cur--;
                        }
                    }
                }
            }
            boolean [][] vis = new boolean [n+2][m+2];
            for(int i = 1; i <= n; i++){
                for(int j = m; j >= 1; j--){
                    if(g [i][j] == 'W' && !vis [i][j]){
                        if(g [i+1][j] == '.'){
                            g [i+1][j] = 'W';
                            g [i][j] = '.';
                            flag = true;
                            vis [i+1][j] = true;
                        }
                    }
                }
            }
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        char g [][] = new char [n+2][m+2];
        for(int i = 1; i <= n; i++){
            String s = readLine();
            for(int j = 1; j <= m; j++){
                g [i][j] = s.charAt(j-1);
            }
        }
        int q = readInt();
        for(int z = 0; z < q; z++){
            int c = readInt();
            if(c == 1){
                for(int i = n; i >= 1; i--){
                    for(int j = 1; j <= m; j++){
                        if(g [i][j] == 'X'){
                            g [i+1][j] = 'X';
                            g [i][j] = '.';
                        }
                    }
                }
                update(g, n, m);
            }
            else{
                for(int i = 1; i <= n; i++){
                    for(int j = 1; j <= m; j++){
                        System.out.print(g [i][j]);
                    }
                    System.out.println();
                }
            }
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Integer.compare(y, p.y);
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}