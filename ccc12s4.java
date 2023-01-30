import java.io.*;
import java.util.*;
public class HelloWorld {
    static int id(String [] a){
        int [] idx = new int [n+1];
        for(int i = 0; i < n; i++){
            idx [a [i].charAt(0)-'0'] = i;
        }
        int id = 0;
        for(int i = n; i >= 1; i--){
            id = id*10 + idx [i];
        }
        return id;
    }
    static char [] recover(int id){
        char [] a = new char [n];
        for(int i = 1; i <= n; i++){
            int idx = id%10;
            if(a [idx] == 0) a [idx] = (char)(i+'0');
            id/=10;
        }
        return a;
    }
    static int move(int v, int from, int to, int id){
        int change = to-from;
        int pos = 1;
        for(int i = 0; i < v-1; i++){
            pos *= 10;
        }
        return id+change*pos;
    }
    static int n;
    public static void main(String [] args) throws IOException{
        while((n = readInt()) != 0){
            if(n == 1){
                System.out.println(0);
                br.readLine();
                continue;
            }
            Queue <Integer> q = new LinkedList();
            int src = id(br.readLine().split(" "));
            q.add(src);
            int m = 0;
            for(int i = 0; i < n; i++) m = m*10+n-1;
            boolean [] vis = new boolean [m+1];
            int [] ans = new int [m+1];
            vis [src] = true;
            boolean inqueue [] = new boolean [m+1];
            while(!q.isEmpty()){
                int id = q.poll();
                char [] b = recover(id);
                for(int i = 1; i < n-1; i++){
                    if(b [i] == 0) continue;
                    int cur = b [i];
                    if(b [i-1] == 0 || b [i-1] > cur){
                        int newid = move(cur-'0', i, i-1, id);
                        if(!vis [newid]){
                            vis [newid] = true;
                            ans [newid] = ans [id]+1;
                            q.add(newid);
                        }
                    }
                    if(b [i+1] == 0 || b [i+1] > cur){
                        int newid = move(cur-'0', i, i+1, id);
                        if(!vis [newid]){
                            vis [newid] = true;
                            ans [newid] = ans [id]+1;
                            q.add(newid);
                        }
                    }
                }
                if(b [0] != 0){
                    int cur = b [0];
                    if(b [1] == 0 || b [1] > cur){
                        int newid = move(cur-'0', 0, 1, id);
                        if(!vis [newid]){
                            vis [newid] = true;
                            ans [newid] = ans [id]+1;
                            q.add(newid);
                        }
                    }
                }
                if(b [n-1] != 0){
                    int cur = b [n-1];
                    if(b [n-2] == 0 || b [n-2] > cur){
                        int newid = move(cur-'0', n-1, n-2, id);
                        if(!vis [newid]){
                            vis [newid] = true;
                            ans [newid] = ans [id]+1;
                            q.add(newid);
                        }
                    }
                }
            }
            int want = 0;
            for(int i = n-1; i >= 0; i--){
                want *= 10;
                want += i;
            }
            if(vis [want]) System.out.println(ans [want]);
            else System.out.println("IMPOSSIBLE");
        }
    }        
    static class pair implements Comparable <pair>{
        long v; int i;
        pair(long a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return Long.compare(v, p.v);
        }
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
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
}