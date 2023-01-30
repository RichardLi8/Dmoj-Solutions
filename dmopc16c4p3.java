import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), s = readInt();
        int [] d = new int [n+1];
        for(int i = 1; i <= n; i++) d [i] = readInt();
        boolean [][] apples = new boolean [n+1][100];
        TreeSet <pair> min [] = new TreeSet [100];
        for(int i = 0; i < 100; i++) min [i] = new TreeSet();
        for(int i = 0; i < s; i++){
            int x = readInt(), a = readInt();
            apples [x][a] = true;
            min [a].add(new pair(d [x], x));
        }
        int q = readInt();
        for(int t = 0; t < q; t++){
            char c = next().charAt(0);
            if(c == 'A'){
                int x = readInt(), a = readInt();
                apples [x][a] = true;
                min [a].add(new pair(d [x], x));
            }
            else if(c == 'S'){
                int x = readInt(), a = readInt();
                if(apples [x][a]){
                    apples [x][a] = false;
                    min [a].remove(new pair(d [x], x));
                }
            }
            else if(c == 'E'){
                int x = readInt(), k = readInt();
                for(int i = 0; i < 100; i++){
                    if(apples [x][i]){
                        apples [x][i] = false;
                        min [i].remove(new pair(d [x], x));
                    }
                }
                d [x] = k;
            }
            else if(c == 'Q'){
                int k = readInt();
                if(k >= 100 || min [k].isEmpty()) System.out.println(-1);
                else System.out.println(min [k].first().i);
            }
        }
    }        
    static class pair implements Comparable <pair>{
        int d, i;
        pair(int a, int b){
            d = a;
            i = b;
        }
        public int compareTo(pair p){
            if(d == p.d) return Integer.compare(i, p.i);
            return Integer.compare(d, p.d);
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