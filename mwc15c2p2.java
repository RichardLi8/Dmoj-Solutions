import java.io.*;
import java.util.*;
/**
 *
 * @author richa
 */
public class ToweringTowers {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
            return Long.parseLong(next());
    }
    static int readInt () throws IOException {
            return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
            return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
            return next().charAt(0);
    }
    static String readLine () throws IOException {
            return br.readLine().trim();
    }
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int [] towers = new int [n];
        int [] seen = new int [n];
        for(int i = 0; i < n; i++){
            towers [i] = readInt();
        }
        Stack <Integer> heights = new Stack <>();
        Stack <Integer> index = new Stack <>();
        for(int i = towers.length-1; i >= 0; i--){
            if(heights.isEmpty()){
                heights.push(towers[i]);
                index.push(i);
            }
            else{
                while(!heights.isEmpty() && heights.peek() < towers[i]){
                    heights.pop();
                    seen[index.peek()] = index.pop()-i;
                }
                heights.push(towers[i]);
                index.push(i);
            }
        }
        while(!index.isEmpty()){
            seen [index.peek()] = index.pop()-0;
        }
        for(int i = 0; i < n; i++){
            System.out.print(seen[i] + " ");
        }
        
    }
}