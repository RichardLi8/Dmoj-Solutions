import java.io.*;
import java.util.*;
public class HelloWorld {
    public static boolean find(int [] freq){
        for(int i = 1; i <= 26; i++){
            if(freq [i] > 1){
                if(freq [i] % 2 == 0){
                    freq [i] = 0;
                }
                else{
                    freq [i] = 1;
                }
                return true;
            }
        }
        return false;
    }
    public static void main(String [] args) throws IOException{
        int [] freq = new int [27];
        int n = readInt();
        String s = next();
        for(int i = 0; i < n; i++){
            freq [s.charAt(i)-'a'+1]++;
        }
        int palindrome = 1;
        while(true){
            boolean flag = find(freq);
            if(flag == false) break;
        }
        int cnt = 0;
        for(int i = 1; i <= 26; i++){
            if(freq [i] == 1) cnt++;
        }
        cnt = Math.max(0, cnt - palindrome);
        palindrome += cnt;
        System.out.println(palindrome);
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