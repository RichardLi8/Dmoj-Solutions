import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        Map <Integer, Integer> w = new HashMap<>();
        for(int i = 0; i < n; i++){
            int m = readInt();
            if(w.containsKey(m)){
                w.put(m, w.get(m)+1);
            }
            else{
                w.put(m, 1);
            }
        }
        int one = 0, two = 0;
        for(int i : w.keySet()){
            if(w.get(i) > one){
                if(two < one) two = one;
                one = w.get(i);
            }
            else if(w.get(i) > two){
                two = w.get(i);
            }
        }
        System.out.println(one+two);
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
}