import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class Main {
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int [] a = new int [n];
        Deque <Integer> stack = new ArrayDeque(); long ans = 0;
        for(int i = 0; i < n; i++){
            a [i] = readInt();
        }
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && a [stack.peekLast()] < a [i]){
                ans += i-stack.pollLast()+1;
            }
            if(!stack.isEmpty()) ans += i-stack.peekLast()+1;
            stack.addLast(i);
        }
        System.out.println(ans);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException{
        return Integer.parseInt(next());
    }
    static long readLong() throws IOException{
        return Long.parseLong(next());
    }
}