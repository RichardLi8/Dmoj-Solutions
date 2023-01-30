import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int s = readInt();
        int count = 0;
        s--;
        int sub = 4;
        while(true){
            if(s-sub < 0)break;
            s -= sub;
            count+=2;
            sub += 4;
        }

        if(s > 0 && s <= (count+1))count++;
        else if(s > 0) count+= 2;
        System.out.println(count);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine() throws IOException {
        return br.readLine();
    }
}