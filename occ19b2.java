import java.io.*;
import java.util.*;

public class HelloWorld {
    
    static int h, w;
    static int [][] grid;
    public static void main(String args[])throws IOException{
        int n = readInt();
        int weeks = readInt();
        Map <String, Integer> value = new HashMap<>();
        Set <String> seen = new HashSet<>();
        String [] movies = new String [n];
        int [] cost = new int [n];
        for(int i = 0; i < n; i++){
            movies [i] = next();
        }
        for(int i = 0; i < n; i++){
            cost [i] = readInt();
        }
        for(int i = 0; i < n; i++){
            value.put(movies [i], cost [i]);
        }
        long ans = 0;
        for(int i = 0; i < weeks; i++){
            String s = next();
            if(!seen.contains(s)){
                ans += value.get(s);
                seen.add(s);
            }
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
}