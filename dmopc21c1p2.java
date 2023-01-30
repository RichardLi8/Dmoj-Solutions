import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] a = new int [n];
        for(int i = 0; i < n; i++){
            a [i] = readInt();
        }
        List <Integer> stk = new ArrayList(); int top = 0; List <Integer> out = new ArrayList(); stk.add(a [0]); out.add(1);
        for(int i = 1; i < n; i++){
            if(a [i] <= stk.get(top)){
                stk.add(a [i]); out.add(1); top++;
            }
            else{
                int cnt = 0;
                for(int j = top; j >= 0; j--){
                    if(stk.get(j) >= a [i]) break;
                    cnt++;
                }
                stk.add(top-cnt+1, a [i]);
                out.add(-cnt); out.add(cnt + 1);
                top++;
            }
        }
        out.add(-top-1);
        System.out.println(out.size());
        for(int v : out){
            System.out.println(v);
        }
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return 0;
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