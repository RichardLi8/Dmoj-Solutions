import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int start = readInt(), end = readInt();
        String flip = "01....9.86";
        int ans = 0;
        for(int i = start; i <= end; i++){
            String s = "" + i;
            String n = "";
            for(int j = s.length()-1; j >= 0; j--){
                int num = Integer.parseInt(s.substring(j, j+1));
                n += flip.charAt(num);
            }
            if(n.equals(s)) ans++;
        }
        System.out.println(ans);
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