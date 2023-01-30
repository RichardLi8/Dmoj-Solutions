import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        long [] nums = new long [n];
        for(int i = 0; i < n; i++){
            nums [i] = readInt();
        }
        Deque <pair> stk = new LinkedList();
        int maxLeft [] = new int [n], maxRight [] = new int [n];
        for(int i = 0; i < n; i++){
            while(!stk.isEmpty() && stk.peekLast().v < nums [i]){
                stk.pollLast();
            }
            maxLeft [i] = !stk.isEmpty()? stk.peekLast().i+1 : 0;
            stk.addLast(new pair(nums [i], i));
        }
        stk.clear();
        for(int i = n-1; i >= 0; i--){
            while(!stk.isEmpty() && stk.peekLast().v <= nums [i]){
                stk.pollLast();
            }
            maxRight [i] = !stk.isEmpty()? stk.peekLast().i-1 : n-1;
            stk.addLast(new pair(nums [i], i));
        }
        int minLeft [] = new int [n], minRight [] = new int [n];
        stk.clear();
        for(int i = 0; i < n; i++){
            while(!stk.isEmpty() && stk.peekLast().v > nums [i]){
                stk.pollLast();
            }
            minLeft [i] = !stk.isEmpty()? stk.peekLast().i+1 : 0;
            stk.addLast(new pair(nums [i], i));
        }
        stk.clear();
        for(int i = n-1; i >= 0; i--){
            while(!stk.isEmpty() && stk.peekLast().v >= nums [i]){
                stk.pollLast();
            }
            minRight [i] = !stk.isEmpty()? stk.peekLast().i-1 : n-1;
            stk.addLast(new pair(nums [i], i));
        }
        long ans = 0;
        for(int i = 0; i < n; i++){
            ans += nums [i] * (i-maxLeft [i]+1) * (maxRight [i]-i+1);
            ans -= nums [i] * (i-minLeft [i]+1) * (minRight [i]-i+1);
        }
        System.out.println(ans);
    }
    static class pair{
        long v; int i;
        pair(long a, int b){
            v = a;
            i = b;
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