import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        int [] first = new int [n+1], second = new int [n+1], pos = new int [m+1]; boolean [] cereal = new boolean [m+1];
        for(int i = 1; i <= n; i++){
            first [i] = readInt();
            second [i] = readInt();
        }
        int [] ans = new int [n+2];
        for(int i = n; i > 0; i--){
            ans [i] = ans [i+1]+1;
            int cur = i;
            while(true){
                if(cereal [first [cur]] && pos [first [cur]] > cur){
                    int tmp = pos [first [cur]];
                    pos [first [cur]] = cur;
                    cur = tmp;
                }
                else if(!cereal [first [cur]]){
                    pos [first [cur]] = cur;
                    cereal [first [cur]] = true;
                    break;
                }
                else if(cereal [second [cur]] && pos [second [cur]] > cur){
                    int tmp = pos [second [cur]];
                    pos [second [cur]] = cur;
                    cur = tmp;
                }
                else if(!cereal [second [cur]]){
                    pos [second [cur]] = cur;
                    cereal [second [cur]] = true;
                    break;
                }
                else{
                    ans [i]--;
                    break;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            System.out.println(ans [i]);
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
}