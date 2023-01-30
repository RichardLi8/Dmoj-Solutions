import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int x = readInt(), y = readInt(), x2 = x + readInt(), y2 = y + readInt();
        int cx = 0, cy = 0, time = readInt(), cnt = 0;
        while(cx < x || cy < y){
            if(x-cx > y-cy){
                cx+=2;
                cy++;
            }
            else{
                cy+=2;
                cx++;
            }
            cnt++;
        }
        if(cnt < time) System.out.println("YES");
        else System.out.println("NO");
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