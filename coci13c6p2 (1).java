import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class Main {
    static int ans;
    static void findAns(int [] letters, int pos, int mask){
        if(mask == (1 << 26)-1){
            ans += 1<<(letters.length-pos);
            return;
        }
        for(int i = pos; i < letters.length; i++){
            findAns(letters, i+1, mask | letters [i]);
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] letters = new int [n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                letters [i] |= 1 << (s.charAt(j)-'a');
            }
        }
        findAns(letters, 0, 0);
        System.out.println(ans);
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