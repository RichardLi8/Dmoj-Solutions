import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class HelloWorld {
    
    
    
    public static void main(String[] args) throws IOException{
        int endD = readInt();
        int endH = readInt();
        int endM = readInt();
        int difD = endD-11;
        int difH = endH-11;
        int difM = endM-11;
        int time = difD * 24 * 60 + difH * 60 + difM;
        if(time < 0){
            System.out.println("-1");
        }
        else{
            System.out.println(time);
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
            return Long.parseLong(next());
    }
    static int readInt () throws IOException {
            return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
            return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
            return next().charAt(0);
    }
    static String readLine () throws IOException {
            return br.readLine().trim();
    }
}