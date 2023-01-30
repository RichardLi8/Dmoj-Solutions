import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int m = readInt();
        ArrayList <Double> rivers = new ArrayList();
        for(int i = 0; i < m; i++){
        	double flow = readDouble();
        	rivers.add(flow);
        }
        while(true){
            int command = readInt();
            if(command == 99){
            int index = readInt()-1;
            double left = readDouble(), right;
            left = left/100;
            right = 1-left;
            rivers.add(index+1, rivers.get(index)*right);
            rivers.set(index, rivers.get(index)*left);
            }
            else if(command == 88){
            	int index = readInt()-1;
            	rivers.set(index, rivers.get(index) + rivers.get(index+1));
            	rivers.remove(index+1);
            }
            else if(command == 77){
            	break;
            }
        }
        for(double flow : rivers){
        	System.out.print(Math.round(flow) + " ");
        }
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
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
}