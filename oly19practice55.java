import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class TandemBicycle {

    public static long pairs(int [] weights, int w){
        long count = 0;
        int prev = weights.length-1;
        for(int i = 0; i < weights.length; i++){
            boolean changed = false;
            for(int j = prev; j > i; j--){
                if(weights [j] <= w - weights [i]){
                    prev = j;
                    changed = true;
                    break;
                }
            }
            if(changed){
                count += prev-i;
            }
            else return count;
        }
        return count;
    }
    
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int w = readInt();
        int [] weights = new int [n];
        for(int i = 0; i < n; i++){
            weights [i] = readInt();
        }
        Arrays.sort(weights);
        System.out.println(pairs(weights, w));
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