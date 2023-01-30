import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), nums1 [] = new int [n+1];
        for(int i = 1; i <= n; i++) {
            nums1 [i] = readInt();
        }
        int m = readInt(), nums2 [] = new int [m+1], pos2 [] = new int [(int)1e6 + 1];
        for(int i = 1; i <= m; i++) {
            nums2 [i] = readInt();
            pos2 [nums2 [i]] = i;
        }
        List <Integer> possible = new ArrayList();
        List <Integer> ans = new ArrayList();
        for(int i = 1; i <= n; i++){
            int pos = pos2 [nums1 [i]];
            if(pos != 0){
                possible.add(pos);
            }
        }
        for(int i = 0; i < possible.size(); i++){
            int x = possible.get(i);
            if(i != 0){
                if(x > ans.get(ans.size()-1)) ans.add(x);
                else{
                    int pos = Collections.binarySearch(ans, x);
                    if(pos < 0) pos = -(pos+1);
                    ans.set(pos, x);
                }
            }
            else ans.add(x);
        }
        System.out.println(ans.size());
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