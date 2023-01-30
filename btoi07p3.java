import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt(), c = readInt();
        int [] a = new int [n];
        for(int i = 0; i < n; i++){
            int x = 0;
            while((x = br.read()) != ' ' && x != '\n'){
                a [i] = a [i] * 10 + x-'0';
            }
        }
        if(m > n){
            System.out.println("NONE");
            return;
        }
        Deque <pair> max = new LinkedList(), min = new LinkedList();
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(!max.isEmpty() && max.peekFirst().i <= i-m) max.pollFirst();
            while(!max.isEmpty() && max.peekLast().v <= a [i]) max.pollLast();
            if(!min.isEmpty() && min.peekFirst().i <= i-m) min.pollFirst();
            while(!min.isEmpty() && min.peekLast().v >= a [i]) min.pollLast();
            max.addLast(new pair(a [i], i));
            min.addLast(new pair(a [i], i));
            if(i+1 < m) continue;
            if(max.peekFirst().v-min.peekFirst().v <= c){
                System.out.println(i-m+2);
                flag = true;
            }
        }
        if(!flag){
            System.out.println("NONE");
            return;
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