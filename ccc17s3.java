import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int heights [] = new int [2001];
        for(int i = 0; i < n; i++) heights [readInt()]++;
        int [] combined = new int [4001];
        int longest = 0;
        for(int i = 1; i <= 2000; i++){
            for(int j = i; j <= 2000; j++){
                if(i == j){
                    combined [i+j] += heights [i]/2;
                }
                else{
                    combined [i+j] += Math.min(heights [i], heights [j]);
                }
                longest = Math.max(combined [i+j], longest);
            }
        }
        int ans = 0;
        for(int i = 1; i <= 4000; i++){
            if(combined [i] == longest) ans++;
        }
        System.out.println(longest + " " + ans);
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}