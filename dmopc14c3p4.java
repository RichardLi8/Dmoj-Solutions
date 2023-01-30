import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class NotEnoughTesters {

    /**
     * @param args the command line arguments
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int [] factors = new int [100001];
        factors [] amount = new factors [100001];
        amount [0] = new factors();
        for(int i = 1; i <= 100001; i++){
            if(Math.floor(Math.sqrt(i))*Math.sqrt(i) == i) factors [i]--;
        }
        for(int i = 1; i < 100001; i++){
            for(int k = 1; k <= Math.sqrt(i); k++){
                if(i%k == 0) factors [i]+=2;
            }
            amount[i] = new factors(amount[i-1].factors, factors [i]);
        }
        for(int i = 0; i < n; i++){
            int wanted = readInt();
            int start = readInt();
            int end = readInt();
            if(wanted > 128) System.out.println(0);
            else System.out.println(amount[end].factors[wanted]-amount[start-1].factors[wanted]);
        }
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}

class factors{
    int [] factors = new int [129];
    factors(){};
    factors(int [] factors, int n){
        this.factors = factors.clone();
        this.factors[n]++;
    }
}