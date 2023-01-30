import java.io.*;
import java.util.*;

public class HelloWorld {
    static int visited [][][] = new int [251][251][126];
    public static int combanations(int n, int k, int min){
        if(visited [n][k][min] != 0) return visited [n][k][min];
        if(n == k) return 1;
        if(k == 1) return 1;
        int sum = 0;
        for(int i = min; i <= n/k; i++){
            sum += combanations(n-i, k-1, i);
        }
        visited [n][k][min] = sum;
        return visited [n][k][min];
    }
    public static void main(String args[])throws IOException{
        int n = readInt();
        int k = readInt();
        System.out.println(combanations(n, k, 1));
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
}