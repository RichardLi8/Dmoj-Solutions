import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt(), k = readInt();
        List <Integer> years = new ArrayList();
        years.add(0);
        for(int i = 0; i < n; i++){
            years.add(readInt());
        }
        Collections.sort(years, Collections.reverseOrder());
        List <Integer> jumps = new ArrayList();
        for(int i = 0; i < n; i++){
            int start = years.get(i)/12 * 12;
            int end = (int) Math.ceil((double)years.get(i+1)/12) * 12;
            int dif = start-end;
            if(start-end <= 0) dif = 0; 
            jumps.add(dif);
        }
        int ans = (int) Math.ceil((double)years.get(0)/12) * 12;
        Collections.sort(jumps, Collections.reverseOrder());
        for(int i = 0; i < k-1; i++){
            ans -= jumps.get(i);
        }
        System.out.println(ans);
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