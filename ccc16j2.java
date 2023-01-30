import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int grid [][] = new int [4][4];
        for(int i = 0; i < 4; i++){
        	for(int j = 0; j < 4; j++){
        		grid [i][j] = readInt();
        	}
        }
        int sum = 0;
        for(int j = 0; j < 4; j++){
        	sum += grid [0][j];
        }
        boolean ans = true;
        //check rows
        for(int i = 1; i < 4; i++){
        	int current_sum = 0;
        	for(int j = 0; j < 4; j++){
        		current_sum += grid [i][j];
        	}
        	if(current_sum != sum){
        		ans = false;
        	}
        }
        //check columns
        for(int j = 0; j < 4; j++){
        	int current_sum = 0;
        	for(int i = 0; i < 4; i++){
        		current_sum += grid [i][j];
        	}
        	if(current_sum != sum){
        		ans = false;
        	}
        }
        if(ans){
        	System.out.println("magic");
        }
        else{
        	System.out.println("not magic");
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