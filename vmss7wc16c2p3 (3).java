import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), nums1 [] = new int [n+1];
        for(int i = 1; i <= n; i++) {
            nums1 [i] = readInt();
        }
        int m = readInt(), pos2 [] = new int [(int)1e6 + 1];
        for(int i = 1; i <= m; i++) {
            pos2 [readInt()] = i;
        }
        br.close();
        List <Integer> possible = new ArrayList();
        List <Integer> ans = new ArrayList();
        for(int i = 1; i <= n; i++){
            int x = pos2 [nums1 [i]];
            if(x != 0){
                if(ans.isEmpty() || x > ans.get(ans.size()-1)) ans.add(x);
                else{
                    int p = (Collections.binarySearch(ans, x)+1) * -1;
                    ans.set(p, x);
                }
            }
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