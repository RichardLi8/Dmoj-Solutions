import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        for(int q = 0; q < 10; q++){
            int r = readInt(), t = readInt(); String ans = next();
            Map <Character, String> change = new HashMap();
            for(int i = 0; i < r; i++){
                change.put(next().charAt(0), next());
            }            
            long letters [] = new long [27], cnt = 0;
            for(int i = 0; i < ans.length(); i++) letters [ans.charAt(i) - 'A' + 1]++;
            for(int i = 0; i < t; i++){
                long newletters [] = new long [27];
                for(Character c : change.keySet()){
                    String cur = change.get(c);
                    for(int j = 0; j < cur.length(); j++){
                        newletters [cur.charAt(j)-'A' + 1] += letters [c - 'A' + 1];    
                    }
                    letters [c - 'A' + 1] = 0;
                }
                for(int j = 1; j <= 26; j++) letters [j] += newletters [j];
                ans = change.get(ans.charAt(0)) + change.get(ans.charAt(ans.length()-1));
            }
            for(int i = 1; i <= 26; i++) cnt += letters [i];
            System.out.println(ans.charAt(0) + "" + ans.charAt(ans.length()-1) + " " + cnt);
        }
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