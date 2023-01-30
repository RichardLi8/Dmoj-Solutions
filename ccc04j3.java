import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        String [] noun = new String [n], adjective = new String [m];
        for(int i = 0; i < n; i++){
    	    noun [i] = next();
        }
        for(int i = 0; i < m; i++){
        	adjective [i] = next();
        }
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < m; j++){
        		System.out.println(noun [i] + " as " + adjective [j]);
        	}
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