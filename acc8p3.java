import java.io.*;
import java.util.*;
public class HelloWorld {
    static boolean check(List <Integer> f){
        int n = f.size()/2;
        for(int i = 0; i < n; i++){
            if((int) f.get(i) != f.get(n+i)) return false;
        }
        return true;
    }
    public static void main(String [] args) throws IOException{
        int m = readInt(), q = readInt();
        List <Integer> f = new ArrayList();
        f.add(1); f.add(1);
        while(true){
            f.add((f.get(f.size()-1) + f.get(f.size()-2))%m);
            if((f.size() & 1) == 0 && check(f)){
                break;
            }
        }
        List <Integer> digit = new ArrayList();
        for(int i = 0; i < f.size()/2; i++){
            int k = f.get(i);
            Deque <Integer> temp = new LinkedList();
            if(k == 0) digit.add(0);
            while(k > 0){
                temp.addLast(k%10);
                k/=10;
            }
            while(!temp.isEmpty()){
                digit.add(temp.removeLast());
            }
        }
        for(int i = 0; i < q; i++){
            int n = (int) ((readLong()-1)%digit.size());
            System.out.println(digit.get(n));
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