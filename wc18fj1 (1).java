import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        Map <Integer, Integer> actors = new HashMap();
        for(int i = 0; i < n; i++){
            int w = readInt();
            if(actors.containsKey(w)){
                actors.put(w, actors.get(w) + 1);
            }
            else actors.put(w, 1);
        }
        int one = 0, two = 0;
        for(int x : actors.keySet()){
            if(one <= actors.get(x)){
                two = one;
                one = actors.get(x);
            }
            else if(two < actors.get(x)){
                two = actors.get(x);
            }
        }
        System.out.println(one + two);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
}