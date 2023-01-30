import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class Main {
    public static void main(String[] args) throws IOException{
        long n = readInt();
        for(int i = 0; i < n; i++){
            long f = readLong(), s = readLong(), ans = Integer.MAX_VALUE, temp = s, cur = 0;
            while(f > s){
                if(f%2 == 1){
                    f++;
                    cur++;
                }
                else{
                    f/=2;
                    cur++;
                }
            }
            ans = cur + s-f;
            while(temp!=1){
                if(temp%2 == 1) cur++;
                temp/=2;
                cur++;
                while(f > temp){
                    if(f%2 == 1){
                        f++;
                        cur++;
                    }
                    else{
                        f/=2;
                        cur++;
                    }
                }
                ans = Math.min(ans, cur+temp-f);
            }
            System.out.println(ans);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException{
        return Integer.parseInt(next());
    }
    static long readLong() throws IOException{
        return Long.parseLong(next());
    }
}