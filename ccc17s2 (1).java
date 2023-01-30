import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int [] nums = new int [n];
        for(int i = 0; i < n; i++) nums [i] = readInt();
        Arrays.sort(nums);
        Stack <Integer> lows = new Stack();
        Queue <Integer> highs = new LinkedList();
        for(int i = 0; i < (n+1)/2; i++){
            lows.add(nums [i]);
        }
        for(int i = (n+1)/2; i < n; i++){
            highs.add(nums [i]);
        }
        for(int i = 0; i < n/2; i++){
            System.out.print(lows.pop() + " ");
            System.out.print(highs.poll() + " ");
        }
        if(!lows.isEmpty()) System.out.println(lows.pop());
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}