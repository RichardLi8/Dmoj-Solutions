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
        boolean [] pass = new boolean [c.length];
        for(int i = 0; i < c.length; i++){
            pass [i] = used [i];
        }
        for(int i = 0; i < c.length; i++){
            if(!pass [i]){
                pass [i] = true;
                findPerm(c, pass, out + c [i]);
                pass [i] = false;
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