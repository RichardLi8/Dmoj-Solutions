import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        ArrayList <Integer> nums = new ArrayList();
        nums.add(readInt());
        for(int i = 1; i < n; i++){
            int m = readInt();
            bsearch(m, nums);
        }
        System.out.println(nums.size());
    }
    static void bsearch(int v, ArrayList <Integer> nums){
        if(v > nums.get(nums.size()-1)) nums.add(v);
        else{
            int l = 0, r = nums.size()-1;
            while(l < r){
                int mid = (l+r)/2;
                if(nums.get(mid) >= v){
                    r = mid;
                }
                else l = mid+1;
            }
            nums.remove(l);
            nums.add(l, v);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
}