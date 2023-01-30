import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String[] args) throws IOException{
        int n = readInt(), k = readInt();
        ArrayList <pair> a = new ArrayList();
        String s = br.readLine();
        for(int i = 0; i < n; i++){
            int num = s.charAt(i)-'0';
            if(a.isEmpty()){
                a.add(new pair(num, 1));
            }
            else{
                if(a.get(a.size()-1).v == num){
                    a.get(a.size()-1).c++;
                }
                else{
                    a.add(new pair(num, 1));
                }
            }
        }
        int cnt = 0, cur = 0;
        Collections.sort(a);
        for(int i = 0; i < a.size() && cnt < k; i++){
            if(a.get(i).v == 1) continue;
            cnt++;
            cur += a.get(i).c;
        }
        System.out.println(cur);
    }
    static class pair implements Comparable <pair>{
        int v, c;
        pair(int a, int b){
            v = a;
            c = b;
        }
        public int compareTo(pair p){
            return -Integer.compare(c, p.c);
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}