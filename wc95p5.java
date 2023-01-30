import java.util.*;
import java.io.*;
import java.math.BigInteger;
/**
 *
 * @author richa
 */
public class Main {
    public static void main(String [] args) throws IOException{
        
        for(int q = 0; q < 5; q++){
            int n = readInt();
            BigInteger num = new BigInteger("1");
            for(int i = 2; i <= n; i++){
                num = num.multiply(new BigInteger(""+i));
            }
            System.out.println("The length of " + n + "! is " + num.toString().length());
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException{
        return Integer.parseInt(next());
    }
}