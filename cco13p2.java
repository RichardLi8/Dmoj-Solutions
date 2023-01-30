import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] wins;
    static void build(int [] v){
        int cnt = v.length, tier = 0;
        for(int i = 0; i < v.length; i++){
            t [0][i] = new pair(v [i], i+1);
        }
        while(cnt != 1){
            tier++;
            cnt>>=1;
            for(int i = 0; i < cnt; i++){
                if(t [tier-1][i*2].x > t [tier-1][i*2+1].x){
                    t [tier][i] = t [tier-1][i*2];
                    wins [t [tier][i].y]++;
                }
                else{
                    t [tier][i] = t [tier-1][i*2+1];
                    wins [t [tier][i].y]++;
                }
            }
        }
        ans = t [tier][0].y;
    }
    static void update(int pos, int [] v){
        int cnt = v.length, tier = 0;
        int cmp1 = 0, cmp2 = 0;
        while(cnt != 1){
            cnt >>= 1;
            tier++;
            if((pos&1) == 1) cmp1 = t [tier-1][pos-1].y-1;
            else cmp1 = t [tier-1][pos+1].y-1;
            cmp2 = t [tier-1][pos].y-1;
            if(v [cmp1] < v [cmp2]){
                wins [cmp1+1] = tier-1;
                t [tier][pos/2] = new pair(v [cmp2], cmp2+1);
                pos/=2;
            }
            else{
                wins [cmp2+1] = tier-1;
                t [tier][pos/2] = new pair(v [cmp1], cmp1+1);
                pos/=2;
            }        
        }
        if(v [cmp1] < v [cmp2]){
            wins [cmp2+1] = tier;
        }
        else wins [cmp1+1] = tier;
        ans = t [tier][0].y;
    }
    static pair [][] t;
    static int ans;
    public static void main(String [] args) throws IOException{
        int n = 1<<readInt(), m = readInt();
        int [] v = new int [n]; t = new pair [Integer.numberOfTrailingZeros(n)+1][n];
        for(int i = 0; i < n; i++){
            v [i] = readInt();
        }       
        wins = new int [n+1];
        build(v);
        for(int q = 0; q < m; q++){
            char c = next().charAt(0);
            if(c == 'R'){
                int i = readInt(), s = readInt();
                v [i-1] = s;
                update(i-1, v);
            }
            else if(c == 'W'){
                System.out.println(ans);
            }
            else{
                int i = readInt();
                System.out.println(wins [i]);
            }
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return -Integer.compare(x, p.x);
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