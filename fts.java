import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 *
 * @author richa
 */
public class FlipTheSwitches {
    
    public static int find(int nums [], int index, int count){
        int want = 0;
        if(count%2 == 0) want = 1;
        for(int i = index; i >= 0; i--){
            if(nums [i] == want) return i;
        }
        return -1;
    }
    
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int [] nums = new int [n];
        String s = next();
        for(int i = 0; i < n; i++){
            nums [i] = Integer.parseInt(s.substring(i, i+1));
        }
        int index = n-1;
        int count = 0;
        while(true){
            index = find(nums, index, count);
            if(index == -1) break;
            count++;
        }
        System.out.println(count);
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