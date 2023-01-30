import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        char [] a = new char [2*n];
        String s = br.readLine();
        for(int i = 0; i < 2*n; i++){
            a [i] = s.charAt(i);
        }
        ArrayList <Integer> next = new ArrayList();
        for(int i = 0; i < 2*n; i+=2){
            if(next.add(i));
        }
        long ans = 0;
        for(int i = 2*n-1; i >= 0; i--){
            if(a [i] == 'I'){
                ans += Math.abs(next.remove(next.size()-1)-i);
            }
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
            return Integer.compare(y, p.y);
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