import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class Main {
    static int ans;
    static void findAns(String [] s, int pos, boolean [] letters, int cnt){
        if(cnt == 26){
            ans += 1<<(s.length-pos);
            return;
        }
        boolean pre [] = new boolean [26];
        for(int i = 0; i < 26; i++){
           pre [i] = letters [i]; 
        }
        for(int i = pos; i < s.length; i++){
            for(int j = 0; j < s [i].length(); j++){
                int letter = s [i].charAt(j)-'a';
                if(!letters [letter]){
                    cnt++;
                    letters [letter] = true; 
                }
            }
            findAns(s, i+1, letters, cnt);
            for(int j = 0; j < s [i].length(); j++){
                int letter = s [i].charAt(j)-'a';
                if(letters [letter] && !pre [letter]){
                    cnt--;
                    letters [letter] = false; 
                }
            }
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        String [] s = new String [n];
        for(int i = 0; i < n; i++){
            s [i] = br.readLine();
        }
        findAns(s, 0, new boolean [26], 0);
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