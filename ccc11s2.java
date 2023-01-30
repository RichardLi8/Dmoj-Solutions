import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), ans = 0;
        char [] student = new char [n], correct = new char [n];
        for(int i = 0; i < n; i++) student [i] = next().charAt(0);
        for(int i = 0; i < n; i++) correct [i] = next().charAt(0);
        for(int i = 0; i < n; i++){
            if(student [i] == correct [i]) ans++;
        }
        System.out.println(ans);
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
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
}