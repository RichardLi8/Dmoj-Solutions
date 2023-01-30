import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        String s = next();
        PriorityQueue <Integer> one = new PriorityQueue (Collections.reverseOrder());
        PriorityQueue <Integer> two = new PriorityQueue (Collections.reverseOrder());
        int first = s.indexOf("1"), last = s.lastIndexOf("1");
        if(first < 0){
            System.out.println(n-1);
            return;
        }
        one.add(first); one.add(n-last-1);
        two.add(first/2); two.add((n-last-1)/2);
        int min = Integer.MAX_VALUE;
        for(int i = first+1, cnt = 0; i <= last; i++){
            if(s.charAt(i) == '0') cnt++;
            else{
                one.add((cnt+1)/2);
                two.add((cnt+1)/3);
                min = Math.min(min, cnt+1);
                cnt = 0;
            }
        }
        System.out.println(Math.min(min, Math.max(two.poll(), Math.min(one.poll(), one.poll()))));
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