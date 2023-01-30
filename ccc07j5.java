import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int min = readInt(), max = readInt(), m = readInt();
        List <Integer> motels = new ArrayList();
        motels.addAll(Arrays.asList(0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000));
        for(int i = 0; i < m; i++) motels.add(readInt());
        Collections.sort(motels);
        long [] dp = new long [m+14];
        dp [0] = 1;
        for(int i = 0; i < m+14-1; i++){
            int cur = motels.get(i);
            for(int j = 1; j < m+14; j++){
                if(motels.get(j)-cur >= min && motels.get(j)-cur <= max) dp [j] += dp [i];
                else if(motels.get(j)-cur > max) break;
            }
        }
        System.out.println(dp [m+14-1]);
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}