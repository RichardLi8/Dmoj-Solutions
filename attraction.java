import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int t = readInt();
        for(int p = 0; p < t; p++){
            int n = readInt(), a = readInt(), b = readInt();
            List <Integer> attractors = new ArrayList();
            for(int i = 0; i < a; i++){
                attractors.add(readInt());
            }
            Collections.sort(attractors);
            PriorityQueue <pair> changes = new PriorityQueue();
            for(int i = 0; i < a-1; i++){
                int dist = attractors.get(i+1)-attractors.get(i)-1;
                if(dist == 0);
                if(dist % 2 == 0){
                    changes.add(new pair(dist/2, 1));
                    changes.add(new pair(dist/2, 1));
                }
                else if(dist == 1) {
                    changes.add(new pair(1, 1));
                }
                else if(dist == 3){
                    changes.add(new pair(2, 1));
                    changes.add(new pair(1, 2));
                }
                else{
                    changes.add(new pair(dist/2+1, 1));
                    changes.add(new pair(dist/2-1, 1));
                    changes.add(new pair(1, 1));
                }
            }
            changes.add(new pair(attractors.get(0)-1, 1));
            changes.add(new pair(n-attractors.get(a-1), 1));
            int total = 0;
            while(b > 0 && !changes.isEmpty()){
                pair cur = changes.poll();
                if(b >= cur.c){
                    total += cur.d;
                    b-=cur.c;
                }
            }
            System.out.println(total);
        }
    }
    static class pair implements Comparable <pair>{
        int d,  c;
        public pair(int a, int b){
            d = a;
            c = b;
        }
        public int compareTo(pair p){
            if(d != p.d) return -Integer.compare(d, p.d);
            return Integer.compare(c, p.c);
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