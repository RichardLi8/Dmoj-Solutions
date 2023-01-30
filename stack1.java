import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        Deque <String> dq = new LinkedList();
        int t = readInt(), m = readInt();
        for(int i = 0; i < t; i++){
            String car = next(); char dir = next().charAt(0);
            if(dir == 'i'){
                dq.addLast(car);
            }
            else{
                if(!dq.isEmpty()){
                    if(dq.peekLast().equals(car)) dq.pollLast();
                    else if(m > 0 && dq.peekFirst().equals(car)){
                        dq.pollFirst();
                        m--;
                    }
                }
            }
        }
        while(!dq.isEmpty()){
            System.out.println(dq.pollFirst());
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