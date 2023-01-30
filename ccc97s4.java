import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class Main {
    public static void main(String [] args) throws IOException{
        String s;
        Map <String, Integer> map;
        int cnt, n = readInt();
        for(int q = 0; q < n; q++){
            map = new HashMap();
            cnt = 1;
            while(!(s = br.readLine()).equals("")){
                String [] a = s.split(" ");
                for(int i = 0; i < a.length; i++){
                    if(map.containsKey(a [i])){
                        System.out.print(map.get(a[i]));
                    }
                    else{
                        map.put(a [i], cnt++);
                        System.out.print(a [i]);
                    }
                    System.out.print(i+1 < a.length? " " : "\n");
                }
            }
            System.out.println();
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException{
        return Integer.parseInt(next());
    }
}