import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int a = readInt(), b = readInt(), c = readInt();
        if(a + b + c != 180){
            System.out.println("Error");
        }
        else if(a == b && b == c){
        	System.out.println("Equilateral");
        }
        else if(a == b || a == c || b == c){
        	System.out.println("Isosceles");
        }
        else{
        	System.out.println("Scalene");
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