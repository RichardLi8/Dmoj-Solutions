import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int nums = (int) Math.sqrt(2*n), groups = nums+1;
        if(nums*groups != 2*n){
            System.out.println("No");
            return;
        }
        int a = 1;
        ArrayList <Integer> [] ans = new ArrayList [groups];
        for(int i = 0; i < groups; i++) ans [i] = new ArrayList();
        for(int i = 0; i < groups; i++){
            for(int j = 1; j <= nums-i; j++){
                ans [i].add(a); ans [i+j].add(a);
                a++;
            }
        }
        System.out.println("Yes");
        System.out.println(groups);
        for(int i = 0; i < groups; i++){
            System.out.print(nums + " ");
            for(int v : ans [i]){
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return -Integer.compare(x, p.x);
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