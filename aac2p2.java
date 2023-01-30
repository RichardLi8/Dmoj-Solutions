import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void freq(int [] nums, int n){
        int val = nums [0], cnt = 1;
        for(int i = 1; i < n; i++){
            if(nums [i] == val){
                cnt++;
            }
            else{
                solve(nums, n, cnt, val);
                cnt = 1;
                val = nums [i];
            }
        }
        solve(nums, n, cnt, val);
    }
    
    public static void solve(int [] nums, int n, int c, int val){
        int l = 0, r = n-1;
        while(l <= r){
            int num = (nums [l] + nums [r]);
            if(num == val*2 && nums [l] != val && nums [r] != val && nums [l] != nums [r]){
                ans = Math.max(ans, c + 2);
                return;
            }
            else if(num < val*2 || nums [l] == val){
                l++;
            }
            else if(num > val*2 || nums [r] == val){
                r--;
            }
        }
        int cnt = 0, index = n-1, sum = 0;
        while(cnt < 2 && index >= 0){
            if(nums [index] != val){
                cnt++;
                sum += nums [index];
            }
            index--;
        }
        if(sum > val && cnt == 2){
            ans = Math.max(ans, c + 1);
        }
        else{
            ans = Math.max(ans, c);
        }
    }
    static int ans = 0;
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] nums = new int [n];
        int odd = 0, even = 0;
        for(int i = 0; i < n; i++){
            nums [i] = readInt();
            if((nums [i] & 1) == 0){
                even++;
            }
            else{
                odd++;
            }
        }
        Arrays.sort(nums);
        if(odd >= 2 || even >= 2){
            ans = 2;
        }
        freq(nums, n);
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