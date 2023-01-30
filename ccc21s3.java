import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] pos = new int [n], time = new int [n], hear = new int [n];
        for(int i = 0; i < n; i++){
            pos [i] = readInt();
            time [i] = readInt();
            hear [i] = readInt();
        }
        int l = 0, r = (int)1e9;
        while(l < r){
            int mid = l + (r-l)/2;
            if(time(pos, time, hear, mid) > time(pos, time, hear, mid+1)){
                l = mid+1;
            }
            else r = mid;
        }
        System.out.println(time(pos, time, hear, l));
    }
    static long time(int [] pos, int [] time, int [] hear, int x){
        long ans = 0;
        for(int i = 0; i < pos.length; i++){
            if(x > pos [i] +hear [i]){
                ans += (long)(x-pos[i]-hear[i]) * time [i];
            }
            else if(x < pos[i]-hear[i]){
                ans += (long)(pos [i] - hear [i] - x) * time [i];
            }
        }
        return ans;
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
}