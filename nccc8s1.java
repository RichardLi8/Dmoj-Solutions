import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        String add = next();
        String original = next();
        Set <String> combos = new TreeSet();
        for(int i = 0; i < add.length(); i++){
            for(int j = 0; j < original.length(); j++){
                if(j == original.length()-1){
                    combos.add(original + add.charAt(i));
                }                                
                combos.add(original.substring(0, j) + add.charAt(i) + original.substring(j));

            }
            for(int j = 0; j < original.length(); j++){
                if(j == original.length()-1){
                    combos.add(original.substring(0, j) + add.charAt(i));
                }
                else combos.add(original.substring(0, j) + add.charAt(i) + original.substring(j+1));
            }
            for(int j = 0; j < original.length(); j++){
                if(original.charAt(j) == add.charAt(i)){
                    if(j == original.length()-1){
                        combos.add(original.substring(0, j));
                    }
                    else combos.add(original.substring(0, j) + original.substring(j+1));
                }
            }
        }
        if(combos.contains(original)) combos.remove(original);
        for(String s : combos) System.out.println(s);
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