import java.io.*;
import java.util.*;
public class HelloWorld {
    static boolean win(int [] a, int [] b){
        int one = 0, two = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(a [i] < b [j]) two++;
                else if(a [i] > b [j]) one++;
            }
        }
        return one > two;
    }
    public static void main(String[] args) throws IOException{
        for(int t = readInt(); t > 0; t--){
            int [] a = new int [4], b = new int [4];
            for(int i = 0; i < 4; i++){
                a [i] = readInt();
            }
            for(int i = 0; i < 4; i++){
                b [i] = readInt();
            }
            if(!win(a, b)){
                int [] temp = a;
                a = b;
                b = temp;
            }
            int c [] = new int [4];
            boolean flag = false;
            Outerloop:
            for(int i = 1; i <= 10; i++){
                c [0] = i;
                for(int j = 1; j <= 10; j++){
                    c [1] = j;
                    for(int k = 1; k <= 10; k++){
                        c [2] = k;
                        for(int l = 1; l <= 10; l++){
                            c [3] = l;
                            if(win(c, a) && win(b, c)){
                                System.out.println("yes");
                                flag = true;
                                break Outerloop;
                            }
                        }
                    }
                }
            }
            if(!flag) System.out.println("no");
        }
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            if(v == p.v) return Integer.compare(w, p.w);
            return Integer.compare(w, p.w);
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