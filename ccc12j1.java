import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int limit = readInt(), speed = readInt();
        if(speed <= limit) System.out.println("Congratulations, you are within the speed limit!");
        else if(speed-limit <= 20) System.out.println("You are speeding and your fine is $100.");
        else if(speed-limit <= 30) System.out.println("You are speeding and your fine is $270.");
        else System.out.println("You are speeding and your fine is $500.");
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