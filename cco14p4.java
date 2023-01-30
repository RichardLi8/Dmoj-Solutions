import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), p = readInt();
        pair nums [] = new pair [n];
        for(int i = 0; i < n; i++){
            nums [i] = new pair(readInt(), readInt(), false);
        }
        int fuel = nums [p-1].f;
        nums [p-1].visited = true;
        Arrays.sort(nums);
        boolean finished = false;
        int ans = 1;
        while(!finished){
            finished = true;
            for(int i = 0; i < n; i++){
                if(!nums [i].visited && fuel >= nums [i].w && nums [i].w <= nums [i].f){
                    fuel -= nums [i].w;
                    fuel += nums [i].f;
                    nums [i].visited = true;
                    ans++;
                    finished = false;
                }
            }
        }
        System.out.println(fuel);
        System.out.println(ans);
    }
    static class pair implements Comparable<pair>{
        int f, w;
        boolean visited;
        public pair(int a, int b, boolean v){
            f = a;
            w = b;
            visited = v;
        }
        public int compareTo(pair p){
            return Integer.compare(w, p.w);
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
}