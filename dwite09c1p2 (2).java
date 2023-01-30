import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class Main {
    static void findPerm(char [] c, boolean [] used, String out){
        if(c.length == out.length()){
            System.out.println(out);
            return;
        }
        for(int i = 0; i < c.length; i++){
            if(!used [i]){
                used [i] = true;
                findPerm(c, used, out + c [i]);
                used [i] = false;
            }
            
        }
    }
    public static void main(String [] args) throws IOException{
        for(int q = 0; q < 5; q++){
            char [] c = br.readLine().toCharArray();
            Arrays.sort(c);
            findPerm(c, new boolean [c.length], "");
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