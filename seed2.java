import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class UnevenSand {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        long min = 1;
        long max = (long) 2e9;
        while(true){
            System.out.println((max+min)/2);
            System.out.flush();
            String s = next();
            if(s.equals("SINKS")) min = (max+min)/2+1;
            else if(s.equals("FLOATS")) max = (max+min)/2-1;
            else break; 
        }
        
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
}