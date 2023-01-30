import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] nums = new int [n];
        for(int i = 0; i < n; i++){
            nums [i] = readInt();
        }
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 1; i < n-1; i++){
            int l = 0, r = n-1;
            while(l < i && r > i){
                if(nums [i]-nums [l] == nums [r]-nums [i]){
                    ans = Math.max(ans, nums [l] + nums [i] + nums [r]);
                }
                if(nums [i]-nums [l] < nums [r]-nums [i]) r--;
                else l++;
            }
        }
        System.out.println(ans);
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