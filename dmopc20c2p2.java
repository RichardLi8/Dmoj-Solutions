import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class LousyChristmasPresents {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int m = readInt();
        Map <Integer, Integer> firstIndex = new HashMap<>();
        Map <Integer, Integer> lastIndex = new HashMap<>();
        for(int i = 0; i < n; i++){
            int num = readInt();
            if(!firstIndex.containsKey(num)){
                firstIndex.put(num, i);
            }
            lastIndex.put(num, i);
        }
        int largest = 0;
        for(int i = 0; i < m; i++){
            int start = readInt();
            int end = readInt();
            if(firstIndex.containsKey(start) && lastIndex.containsKey(end) && firstIndex.get(start) <= lastIndex.get(end)){
                if(largest < lastIndex.get(end)-firstIndex.get(start)+1){
                    largest = lastIndex.get(end)-firstIndex.get(start)+1;
                }
            }
        }
        System.out.println(largest);
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    
}