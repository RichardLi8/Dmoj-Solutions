import java.io.*;
import java.util.*;

public class HelloWorld {
    static int perfect = 0;
    public static void main(String [] args) throws IOException{
        int prblms = readInt(), ppl = readInt(), time = readInt();
        int [] times = new int [prblms];
        for(int i = 0; i < prblms; i++) {
            times [i] = readInt();
        }
        double [] satisfy = new double [prblms];
        for(int i = 0; i < ppl; i++){
            double h = readDouble();
            if(h == 0) perfect++;
            else{
                for(int j = 0; j < h; j++){
                    int n = readInt();
                    satisfy [n-1] += 1/h;
                }
            }
        }
        double dp [] = new double [time+1];
        for(int i = 0; i < prblms; i++){
            double s = satisfy [i]; int t = times [i];
            for(int j = time; j >= t; j--){
                dp [j] = Math.max(dp [j], dp [j-t] + s);
            }
        }
        System.out.printf("%.2f\n",dp [time] + perfect);
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
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static String readLine() throws IOException {
        return br.readLine();
    }
}