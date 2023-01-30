import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] nums = new int [n];
        for(int i = 0; i < n; i++){
            nums [i] = readInt();
        }
        long ans = Long.MIN_VALUE;
        int cur = 1;
        for(int i = 1; i < n; i++){
            if(nums [i] != nums [i-1]){
                cur++;
            }
            else{
                cur += flip(nums, i);
                ans = Math.max(cur, ans);
                cur = 1;
            }
        }
        ans = Math.max(ans, cur);
        System.out.println(ans);
    }
    static int flip(int [] nums, int index){
        int ans = 1;
        for(int i = index+1; i < nums.length; i++){
            if(nums [i] != nums [i-1]) ans++;
            else{
                ans++;
                for(int j = i+1; j < nums.length; j++){
                    if(nums [j] != nums [j-1]) ans++;
                    else break;
                }
                break;
            }
        }
        return ans;
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