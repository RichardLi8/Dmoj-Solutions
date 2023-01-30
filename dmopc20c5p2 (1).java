import java.io.*;
import java.util.*;
public class HelloWorld {
    public static int gcd(int a, int b){
        for(int i = Math.min(a, b); i >= 1; i--){
            if(a % i == 0 && b % i == 0) return i;
        }
        return 1;
    }
    public static void main(String [] args) throws IOException{
        double a = readInt(), b = readInt();
        double n = Math.min(a, b), m = Math.max(a, b);
        double slope = n/m;
        int gcd = gcd((int) n, (int)m);
        ArrayList <pair> pixels = new ArrayList();
        for(int i = 1; i <= m/gcd; i++){
            int start = (int)Math.ceil(slope*Math.max(1, i-1));
            int height = (int) Math.ceil(slope * i);
            for(int j = start; j <= height; j++){
                pixels.add(new pair(j, i));
            }
        }
        System.out.println(pixels.size()*gcd);
        int lastx = 0, lasty = 0;
        if(a >= b){
            for(int i = 0; i < gcd; i++){
                for(pair p : pixels){
                    System.out.println((p.y + lasty) + " " + (lastx + p.x));
                }
                lastx += pixels.get(pixels.size()-1).x;
                lasty += pixels.get(pixels.size()-1).y;
            }
        }
        else{
            for(int i = 0; i < gcd; i++){
                for(pair p : pixels){
                    System.out.println((p.x + lastx) + " " + (lasty + p.y));
                }
                lastx += pixels.get(pixels.size()-1).x;
                lasty += pixels.get(pixels.size()-1).y;
            }
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        public pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x != p.x) return Integer.compare(x, p.x);
            return Integer.compare(y, p.y);
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