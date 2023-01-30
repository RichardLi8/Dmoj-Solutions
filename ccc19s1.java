import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        String s = next();
        int [] nums = {1,2,3,4};
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'H'){
                int temp = nums [0];
                nums [0] = nums [2];
                nums [2] = temp;
                temp = nums [1];
                nums [1] = nums [3];
                nums [3] = temp;
            }
            else{
                int temp = nums [0];
                nums [0] = nums [1];
                nums [1] = temp;
                temp = nums [2];
                nums [2] = nums [3];
                nums [3] = temp;
            }
        }
        System.out.println(nums [0] + " " + nums [1] + "\n" + nums [2] + " " + nums [3]);
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