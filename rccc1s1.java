import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), maxc = readInt(), maxv = readInt();
        String s = next();
        String vowels = "aeiouy";
        int c = 0, v = 0;
        for(int i = 0; i < n; i++){
            String cur = s.substring(i, i+1);
            if(cur.equalsIgnoreCase("y")){
                v++;
                c++;
            }
            else if (vowels.contains(cur)){
                v++;
                c = 0;
            }
            else{
                c++;
                v = 0;
            }
            if(v > maxv || c > maxc){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}