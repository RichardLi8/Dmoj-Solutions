import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class HelloWorld {
    public static boolean isPrime(int a){
        if(a%2==0)return false;
        for(int i = 3; i <= Math.sqrt(a); i+=2){
            if(a%i==0)return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int [] means = new int [n];
        for(int i = 0; i < n; i++){
            means [i] = readInt();
        }
        for(int i = 0; i < n; i++){
            int one = 3;
            int two = means[i]*2-3;
            while(one <= means[i]){
                if(isPrime(one)&& isPrime(two)){
                    break;
                }
                one+=2;
                two-=2;
            }
            System.out.println(one + " " + two);
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