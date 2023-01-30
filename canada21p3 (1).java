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
            Deque <Integer> stk = new LinkedList();
            ArrayList <Integer> changed = new ArrayList();
            int cnt = 0;
            for(int i = 0; i < n; i++){
                while(!stk.isEmpty() && stk.peekLast() > nums [i]){
                    if(cnt == k) break;
                    changed.add(stk.pollLast());
                    cnt++;
                }
                stk.addLast(nums [i]);
            }
            while(!stk.isEmpty() && cnt < k){
                changed.add(stk.pollLast());
                cnt++;
            }
            Collections.sort(changed);
            while(!stk.isEmpty()){
                System.out.print(stk.pollFirst());
            }
            for(int v : changed){
                System.out.print(v);
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