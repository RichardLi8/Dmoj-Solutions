import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), ans = 0;
        String [] s = br.readLine().split(" ");
        for(int j = 0; j < s.length; j++){
            boolean name = false;
            if(Character.isUpperCase(s [j].charAt(0))) name = true;
            for(int k = 1; k < s [j].length(); k++){
                if(!Character.isLowerCase(s [j].charAt(k)) && s [j].charAt(k) != '.' && s [j].charAt(k) != '!' && s [j].charAt(k) != '?'){
                    name = false;
                    break;
                }
            }
            if(name) ans++;
            if(s [j].charAt(s [j].length()-1) == '.' || s [j].charAt(s [j].length()-1) == '!' || s [j].charAt(s [j].length()-1) == '?'){
                System.out.println(ans);
                ans = 0;
            }
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(y != p.y) return -Integer.compare(y, p.y);
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
}