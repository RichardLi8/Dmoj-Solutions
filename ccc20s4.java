import java.io.*;
import java.util.*;
public class HelloWorld {
    static int solve(String perm, char [] a, int [] cntA, int [] cntB, int [] cntC){
        int idx = 0, ans = Integer.MAX_VALUE;
        int stA = 0, edA = 0, stB = 0, edB = 0, stC = 0, edC = 0;
        for(int i = 0; i < 3; i++){
            if(perm.charAt(i) == 'A'){
                stA = idx+1;
                edA = idx+cntA[a.length/2];
                idx = edA;
            }
            else if(perm.charAt(i) == 'B'){
                stB = idx+1;
                edB = idx+cntB[a.length/2];
                idx = edB;
            }
            else{
                stC = idx+1;
                edC = idx+cntC[a.length/2];
                idx = edC;
            }
        }
        for(int i = 0; i <= a.length/2; i++){
            int nonA = edA-stA+1-(cntA [edA+i]-cntA[stA-1+i]);
            int cur = 0;
            int sub = Math.min(cntA [edB+i]-cntA[stB-1+i], cntB [edA+i]-cntB [stA-1+i]);
            cur += sub;
            nonA -= sub;
            sub = Math.min(cntA [edC+i]-cntA[stC-1+i], cntC [edA+i]-cntC [stA-1+i]);
            cur += sub;
            nonA -= sub;
            cur += 2*nonA;
            sub = Math.min(cntB [edC+i]-cntB[stC-1+i], cntC [edB+i]-cntC [stB-1+i]);
            cur += sub;
            ans = Math.min(ans, cur);
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        String s = readLine();
        int n = s.length();
        char [] a = new char [2*n+1];
        for(int i = 1; i <= n; i++){
            a [i] = a [i+n] = s.charAt(i-1);
        }
        int [] cntA = new int [2*n+1], cntB = new int [2*n+1], cntC = new int [2*n+1];
        for(int i = 1; i <= 2*n; i++){
            if(a [i] == 'A'){
                cntA [i]++;
            }
            else if(a [i] == 'B'){
                cntB [i]++;
            }
            else{
                cntC [i]++;
            }
            cntA [i] += cntA [i-1];
            cntB [i] += cntB [i-1];
            cntC [i] += cntC [i-1];
        }
        int ans = solve("ABC", a, cntA, cntB, cntC);
        ans = Math.min(ans, solve("ACB", a, cntA, cntB, cntC));
        ans = Math.min(ans, solve("BAC", a, cntA, cntB, cntC));
        ans = Math.min(ans, solve("BCA", a, cntA, cntB, cntC));
        ans = Math.min(ans, solve("CAB", a, cntA, cntB, cntC));
        ans = Math.min(ans, solve("CBA", a, cntA, cntB, cntC));
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Integer.compare(y, p.y);
            return Integer.compare(x, p.x);
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