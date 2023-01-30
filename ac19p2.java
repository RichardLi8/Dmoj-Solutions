import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int shift = readInt()%26;
        String s = br.readLine();
        char [] letters = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(letters [i] != ' ') {
                letters [i] += shift;
                if(letters [i] > 'z') letters [i] -= 26;
            }
        }
        for(int i = 0; i < s.length(); i++){
            System.out.print(letters [i]);
        }
        System.out.println("");
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