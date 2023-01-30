import java.io.*;
import java.util.*;
public class HelloWorld {
    static boolean solve(int [] a, int [] b){
        long [] psa = new long [1000001], sum = new long [1000001];
        for(int i = 0; i < n; i++){
            psa [b [i]]++;
            sum [b [i]] += b [i];
        }
        for(int i = 1; i <= 1000000; i++){
            psa [i] += psa [i-1];
            sum [i] += sum [i-1];
        }
        ans = 0;
        for(int i = 0; i < n; i++){
            if(psa [a [i]-1] == n){
                return false;
            }
            ans += sum [a [i]] + (n-psa [a [i]]) * a [i];
        }
        return true;
    }
    static int n;
    static long ans;
    public static void main(String [] args) throws IOException{
        n = readInt();
        int [] front = new int [n], back = new int [n+1]; 
        for(int i = 0; i < n; i++){
            front [i] = readInt();
        }
        for(int i = 0; i < n; i++){
            back [i] = readInt();
        }
        boolean works = true;
        works &= solve(front, back);
        works &= solve(back, front);
        System.out.println(works? ans : -1);
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