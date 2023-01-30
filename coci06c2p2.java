import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class HelloWorld {
    
    
    
    public static void main(String[] args) throws IOException{
        int [] numbers = new int [3];
        for(int i = 0; i < 3; i++){
            numbers [i] = readInt();
        }
        String order = readLine();
        Arrays.sort(numbers);
        for(int i = 0; i < 3; i++){
            if(order.charAt(i) == 'A'){
                System.out.print(numbers[0] + " ");
            }
            else if(order.charAt(i) == 'B'){
                System.out.print(numbers[1] + " ");
            }
            else if(order.charAt(i) == 'C'){
                System.out.print(numbers[2] + " ");
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