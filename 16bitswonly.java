import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        for(int i = 0; i < n; i++){
            BigInteger x = new BigInteger(next()), y = new BigInteger(next()), z = new BigInteger(next());
            if(x.multiply(y).equals(z)) System.out.println("POSSIBLE DOUBLE SIGMA");
            else System.out.println("16 BIT S/W ONLY");
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
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static String readLine() throws IOException {
        return br.readLine();
    }
}