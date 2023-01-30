import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 *
 * @author richa
 */
public class Test {

    public static long findFirst(long n, long start, long end){
        for(long i = start; i <= end; i++){
            if(i % n == 0) return i;
        }
        return -1;
    }
    public static long findLast(long n, long start, long end){
        for(long i = end; i >= start; i--){
            if(i % n == 0) return i;
        }
        return -1;
    }
    public static long gcf(long a, long b){
        int gcf = 1;
        for(int i = 2; i <= a && i <= b; i++){
            if(a % i == 0 && b % i == 0){
                gcf = i;
            }
        }
        return gcf;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long start = input.nextLong();
        long end = input.nextLong();
        long first = input.nextLong();
        long second = input.nextLong();
        long both = (second*first)/gcf(first, second);
        long appears1 = (findLast(first, start, end)-findFirst(first, start, end))/first + 1;
        long appears2 = (findLast(second, start, end)-findFirst(second, start, end))/second + 1;
        long shared = (findLast(both, start, end)-findFirst(both, start, end))/(both) + 1;
        System.out.println(appears1 + appears2 - shared);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }  
}