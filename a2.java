import java.io.*;
import java.util.*;

public class HelloWorld {
    
    public static void main(String [] args) throws IOException{
        System.out.println("Ready");
        String s = br.readLine();
        while(!s.equals("  ")){
            if(s.contains("p") && s.contains("q") || s.contains("d") && s.contains("b")) System.out.println("Mirrored pair");
            else System.out.println("Ordinary pair");
            s = br.readLine();
        }
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