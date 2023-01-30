import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] bit;
    static void update(int i, int v){
        for(; i < bit.length; i += i&-i){
            bit [i] += v;
        }
    }
    static int query(int i){
        int sum = 0;
        for(; i > 0; i -= i&-i){
            sum += bit [i];
        }
        return sum;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        pair [] nums = new pair [n]; int cnt = 0;
        char [] cmd = new char [n]; pair [] a = new pair [n];
        for(int i = 0; i < n; i++){
            char c = next().charAt(0);
            if(c == 'N'){
                int x = readInt(), r = readInt();
                a [i] = new pair(x, r); cmd [i] = c;
                nums [cnt++] = a [i];
            }
            else if(c == 'M'){
                int x = readInt(), r = readInt();
                a [i] = new pair(x, r); cmd [i] = c;
                nums [cnt++] = a [i];
            }
            else{
                int x = readInt();
                a [i] = new pair(x, 0); cmd [i] = c;
            }
        }
        int [] rank = new int [1000001];
        int [] person = new int [cnt+1];
        bit = new int [cnt+1];
        Arrays.sort(nums, 0, cnt);
        for(int i = 0; i < cnt; i++) nums [i].y = i+1;
        for(int i = 0; i < n; i++){
            char c = cmd [i];
            if(c == 'N'){
                update(a [i].y, 1);
                rank [a[i].x] = a [i].y;
                person [a [i].y] = a [i].x;
            }
            else if(c == 'M'){
                update(rank [a[i].x], -1);
                update(a[i].y, 1);
                rank [a[i].x] = a [i].y;
                person [a [i].y] = a [i].x;
            }
            else{
                int v = a [i].x;
                int l = 1, r = cnt;
                while(l <= r){
                    int mid = (l+r)/2;
                    if(query(mid) < v){
                        l = mid+1;
                    }
                    else r = mid-1;
                }
                System.out.println(person [l]);
            }
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return -Integer.compare(y, p.y);
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