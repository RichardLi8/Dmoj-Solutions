import java.io.*;
import java.util.*;
public class HelloWorld {
    static long gcd(long a, long b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        pair [] p = new pair [n];
        for(int i = 0; i < n; i++){
            p [i] = new pair(readLong(), readLong());
        }
        pair [] b = new pair [m];
        Map <Long, Integer> [] map = new HashMap [m];
        long cnt = 0;
        TreeSet <pair> slope = new TreeSet();
        ArrayList <pair> s = new ArrayList();
        for(int i = 0; i < m; i++){
            b [i] = new pair(readLong(), readLong());
            long gcd = gcd(b [i].x, b [i].y);
            b [i].x/=gcd; b [i].y/=gcd;
            if(b [i].y < 0){
                b [i].x *= -1; b [i].y *= -1;
            }
            if(slope.contains(b [i])) continue;
            s.add(b [i]);
            slope.add(b [i]);
        }
        for(int i = 0; i < s.size(); i++) map [i] = new HashMap();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < s.size(); j++){
                if(map [j].containsKey(s.get(j).x*p [i].x-s.get(j).y*p [i].y)){
                    cnt+=map [j].get(s.get(j).x*p [i].x-s.get(j).y*p [i].y);
                }
                map [j].put(s.get(j).x*p [i].x-s.get(j).y*p [i].y, map [j].getOrDefault(s.get(j).x*p [i].x-s.get(j).y*p [i].y, 0)+1);
            }
        }
        System.out.println(cnt);
    }
    static class pair implements Comparable <pair>{
        long x, y;
        pair(long a, long b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Long.compare(y, p.y);
            return Long.compare(x, p.x);
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
        return br.readLine();
    }
}