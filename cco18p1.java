import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        char [] arr1, arr2;
        int [] nums1 = new int [n+1], nums2 = new int [n+1];
        arr1 = (" " + next()).toCharArray();
        for(int i = 1; i <= n; i++) nums1 [i] = readInt();
        arr2 = (" " + next()).toCharArray();
        for(int i = 1; i <= n; i++) nums2 [i] = readInt();
        int dp [][] = new int [n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if((arr1 [i] > arr2 [j] && nums1 [i] > nums2 [j]) || (arr1 [i] < arr2 [j] && nums1 [i] < nums2 [j])){
                    dp [i][j] = dp [i-1][j-1] + nums1 [i] + nums2 [j];
                }
                dp [i][j] = Math.max(dp [i-1][j], Math.max(dp [i][j-1], dp [i][j]));
            }
        }        
        System.out.println(dp [n][n]);
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
}