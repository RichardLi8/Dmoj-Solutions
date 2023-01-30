import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), t = readInt(), dp [] = new int [t+1];
        for(int i = 0; i < n; i++){
            int v = readInt(), w = readInt();
            for(int j = t; j >= w; j--){
                dp [j] = Math.max(dp [j], dp [j-w]+v);
            }
        }
        System.out.println(dp [t]);
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}