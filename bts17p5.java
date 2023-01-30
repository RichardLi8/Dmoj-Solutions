import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        TreeSet <Integer> set = new TreeSet();
        List <pair> chars [] = new ArrayList [26];
        for(int i = 0; i < 26; i++){
            chars [i] = new ArrayList();
        }
        for(int i = 0; i < m; i++){
            chars [next().charAt(0)-'a'].add(new pair(readInt(), readInt()));
        }
        char [] out = new char [n+1];
        ArrayList <data> cmds = new ArrayList();
        for(int i = 0; i < 26; i++){
            Collections.sort(chars [i]);
            int pre = 0, cnt = 0;
            for(pair p : chars [i]){
                if(p.x < cnt){
                    System.out.println(-1);
                    return;
                }
                cmds.add(new data((char)('a'+i), p.x-cnt, p.y, pre));
                pre = p.y; cnt = p.x;
            }
        }
        for(int i = 1; i <= n; i++) set.add(i);
        Collections.sort(cmds);
        for(data d : cmds){
            for(int i = 0; i < d.x; i++){
                Integer nxt = set.ceiling(d.p+1);
                if(nxt != null && nxt <= d.i){
                    set.remove(nxt);
                    out [nxt] = d.c;
                }
                else{
                    System.out.println(-1);
                    return;
                }
            }
        }
        TreeSet <Character> fill = new TreeSet();
        for(char i = 'a'; i <= 'z'; i++) fill.add(i);
        int first = n+1;
        if(!set.isEmpty()) first = set.first();
        for(data d : cmds){
            if(d.i >= first){
                fill.remove(d.c);
            }
        }
        if(fill.isEmpty() && !set.isEmpty()){
            System.out.println(-1);
            return;
        }
        for(int i = 1; i <= n; i++){
            System.out.print(out [i] == 0? (char) fill.first() : out [i]);
        }
        System.out.println();
    }
    static class data implements Comparable <data>{
        char c; int x, i, p;
        data(char a, int b, int c, int d){
            this.c = a;
            x = b;
            i = c;
            p = d;
        }
        public int compareTo(data d){
            return Integer.compare(i, d.i);
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return Integer.compare(y, p.y);
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