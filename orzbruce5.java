import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt(), len = readInt();
        String [] names = new String [n];
        for(int i = 0; i < n; i++) names [i] = next();
        boolean [][] inputs = new boolean [30][30];
        for(int i = 0; i < m; i++){
            int l = readInt()-1, r = readInt()-1;
            if(l == r) continue;
            inputs [l][r] = true;
        }
        ArrayList <Integer> left = new ArrayList(), right = new ArrayList();
        for(int i = 0; i < 30; i++){
            for(int j = i+1; j < 30; j++){
                if(inputs [i][j]){
                    left.add(i);
                    right.add(j);
                }
            }
        }
        int ans = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < left.size(); j++){
                if(!palindrome(left.get(j), right.get(j), names [i])){
                    ans--;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
    static boolean palindrome(int l, int r, String s){
        int m = (r - l - 1)/2;
        for(int i = 0; i <= m; i++){
            if(s.charAt(l+i) != s.charAt(r-i)) return false;
        }
        return true;
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