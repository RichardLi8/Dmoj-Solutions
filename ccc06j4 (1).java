import java.io.*;
import java.util.*;

public class HelloWorld {
    static boolean [][] adj = new boolean [8][8];
    
    public static void main(String [] args) throws IOException{
        adj [1][4] = true;
        adj [1][7] = true;
        adj [2][1] = true;
        adj [3][4] = true;
        adj [3][5] = true;
        int[] req = {0, 1, 0, 0, 2, 1, 0, 1};
        int a = readInt(), b = readInt();
        while(a != 0){
            adj [a][b] = true;
            req [b]++;
            a = readInt(); b = readInt();
        }
        int count = 0;
        String out = "";
        for(int i = 0; i < 7; i++){
            for(int j = 1; j <= 7; j++){
                if(req [j] == 0){
                    for(int k = 1; k <= 7; k++){
                        if(adj [j][k]){
                            req [k]--;
                        }
                    }
                    req [j] = -1;
                    count++;
                    out += j + " ";
                    break;
                }
            }
        }
        System.out.println(count == 7?out:"Cannot complete these tasks. Going to bed.");
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
}