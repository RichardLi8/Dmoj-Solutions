import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        List <Double> rivers = new ArrayList();
        for(int i = 0; i < n; i++) rivers.add(readDouble());
        int input;
        while((input = readInt()) != 77){
            if(input == 99){
                int idx = readInt()-1;
                double left = readDouble()/100, right = 1-left;
                double old = rivers.remove(idx);
                rivers.add(idx, old*right); rivers.add(idx, old*left);
            }
            else{
                int idx = readInt()-1;
                rivers.set(idx, rivers.get(idx) + rivers.remove(idx+1));
            }
        }
        for(int i = 0; i < rivers.size(); i++){
            System.out.print((int)(double)rivers.get(i) + " ");
        }
        System.out.println();
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