import java.io.*;
import java.util.*;

public class HelloWorld {
    
    static int h, w;
    static int [][] grid;
    public static void main(String args[])throws IOException{
        String s = next().toUpperCase();
        int underscores = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '_') underscores++;
        }
        if(s.startsWith("DARCY") && s.endsWith("LIU") && underscores > 1 && s.length() == underscores + 8) System.out.println("fake");
        else if(s.equals("DARCY_LIU")) System.out.println("real");
        else System.out.println("other user");
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
}