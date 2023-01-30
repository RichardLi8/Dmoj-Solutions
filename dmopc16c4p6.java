import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        int [] nums = new int [n];
        for(int i = 0; i < n; i++){
            nums [i] = readInt();
        }
        Deque <pair> stk = new LinkedList();
        int minLeft [] = new int [n], minRight [] = new int [n];
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
        
        
        long heights [] = new long [1000001];
        for(int i = 0; i < n; i++){
            heights [nums [i]] += (long)(i-minLeft [i]+1) * (minRight [i]-i+1);
        }
        for(int i = 1; i <= 1000000; i++){
            heights [i] += heights [i-1];
        }
        for(int t = 0; t < q; t++){
            int x = readInt(), y = readInt();
            System.out.println(heights [y]-heights [x-1]);
        }
    }
    static class pair{
        int v, i;
        pair(int a, int b){
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