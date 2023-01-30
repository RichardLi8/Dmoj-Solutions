import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class HelloWorld {
    
    
    
    public static void main(String[] args) throws IOException{
        int n = readInt();
        for(int j = 0; j < n; j++){
            String s = readLine();
            Stack <String> bracket = new Stack <> ();
            boolean valid = true;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '('){
                    bracket.push("(");
                }
                else if(s.charAt(i) == ')'){
                    if(bracket.isEmpty()){
                        valid = false;
                        break;
                    }
                    else{
                        bracket.pop();
                    }
                }
            }
            if(valid && bracket.isEmpty()){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
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