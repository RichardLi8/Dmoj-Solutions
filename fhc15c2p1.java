import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int t = readInt();
        for(int q = 1; q <= t; q++){
            int n = readInt();
            int [] og = new int [n];
            for(int i = 0; i < n; i++){
                og [i] = readInt();
            }
            boolean [] used = new boolean [n+2];
            int cnt = 1;
            int l = 0, r = n-2;
            used [og [n-1]] = true;
            while(l <= r){
                boolean flag = false;
                int a = og [l], b = og [r];
                if(used [a-1] || used [a+1]){
                    used [a] = true;
                    l++;
                    cnt++;
                    flag = true;
                }
                else if(used [b-1] || used [b+1]){
                    used [b] = true;
                    r--;
                    cnt++;
                    flag = true;
                }
                if(!flag) break;
            }
            Arrays.fill(used, false);
            int cnt2 = 1;
            l = 1; r = n-1;
            used [og [0]] = true;
            while(l <= r){
                boolean flag = false;
                int a = og [l], b = og [r];
                if(used [a-1] || used [a+1]){
                    used [a] = true;
                    l++;
                    cnt2++;
                    flag = true;
                }
                else if(used [b-1] || used [b+1]){
                    used [b] = true;
                    r--;
                    cnt2++;
                    flag = true;
                }
                if(!flag) break;
            }
            System.out.println("Case #" + q + ": " + (cnt == n || cnt2 == n ? "yes" : "no"));
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