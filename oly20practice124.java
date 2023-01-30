import java.io.*;
import java.util.*;
/**
 *
 * @author richa
 */
public class CandyDivision {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int nums [] = new int [n];
        for(int i = 0; i < n; i++){
            nums [i] = readInt();
        }
        if(n % 2 == 1){
            System.out.println("0");
        }
        else{
            Arrays.sort(nums);
            System.out.println(nums [n/2] - nums [n/2-1]);
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
}