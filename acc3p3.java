import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(); String [] s = new String [n]; int [] pre = new int [n], cur = new int [n];
        for(int i = 0; i < n; i++){
            s [i] = br.readLine();
            cur [i] = -1;
        }
        char l = 'z'; StringBuilder ans = new StringBuilder();
        while(l >= 'a'){
            boolean all = true;
            for(int i = 0; i < n; i++){
                boolean flag = false;
                pre [i] = cur [i];
                for(int j = cur [i]+1; j < s [i].length(); j++){
                    if(s [i].charAt(j) == l){
                        flag = true;
                        cur [i] = j;
                        break;
                    }
                }
                if(!flag){
                    for(int k = 0; k <= i; k++){
                        cur [k] = pre [k];
                    }
                    l--;
                    all = false;
                    break;
                }
            }
            if(all) ans.append(l);
        }
        if(ans.length() == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            return p.w-w;
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