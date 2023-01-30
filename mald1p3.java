import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String[] args) throws IOException{
        int n = readInt(), k = readInt();
        int [] a = new int [n];
        int cnt = 0, day = 1;
        for(int i = 0; i < n; i++){
            a [i] = readInt();
        }
        Arrays.sort(a); int l = 0, r = n-1;
        int sum = 0, start = 1;
        for(int i = 0; i < n; i++){
            sum++;
            start = a [i];
            if(sum >= k) break;
        }
        for(int i = start; cnt != n; i++){
            day = i;
            int add = 0;
            while(l <= r && a [l] <= day){
                l++;
                cnt++;
            }
            boolean flag = false;
            for(int j = 0; j < cnt/k; j++){
                if(r >= l){
                    r--;
                    add++;
                    flag = true;
                }
            }
            cnt += add;
            if(flag) day++;
        }
        System.out.println(day);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x != p.x) return Integer.compare(x, p.x);
            return Integer.compare(y, p.y);
        }
    }
    static PrintWriter pr = new PrintWriter(System.out);
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