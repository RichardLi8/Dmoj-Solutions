import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        for(int t = readInt(); t > 0; t--){
            String s = br.readLine(); int n = s.length();
            int [] nums = new int [n];
            for(int i = 0; i < n; i++){
                nums [i] = s.charAt(i)-'0';
            }
            s = null;
            int k = readInt();
            Deque <pair> stk = new LinkedList();
            int cnt = 1;
            PriorityQueue <pair> pq = new PriorityQueue();
            for(int i = 0; i < n; i++){
                while(!stk.isEmpty() && stk.peekLast().v > nums [i]){
                    pair p = stk.pollLast();
                    pq.add(new pair(p.i, cnt++));
                }
                stk.addLast(new pair(nums [i], i));
            }
            boolean [] removed = new boolean [n];
            PriorityQueue <Integer> changed = new PriorityQueue();
            while(k > 0 && !pq.isEmpty()){
                removed [pq.peek().v] = true;
                changed.add(nums [pq.poll().v]);
                k--;
            }
            int idx = n-1;
            while(k > 0){
                if(removed [idx]) idx--;
                else if(nums [idx] > changed.peek()){
                    changed.add(nums [idx]);
                    removed [idx] = true;
                    idx--;
                    k--;
                }
                else break;
            }
            for(int i = 0; i < n; i++){
                if(!removed [i]){
                    System.out.print(nums [i]);
                }
            }
            
            while(!changed.isEmpty()){
                System.out.print(changed.poll());
            }
            System.out.println();
        }
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return Integer.compare(i, p.i);
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