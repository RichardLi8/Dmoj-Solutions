import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        boolean composite [] = new boolean [(int)1e7+1];
        for(int i = 2; i < 1e7+1; i++){
            if(!composite [i]){
                for(int j = (int) Math.pow(i, 2); j < 1e7+1; j+= i){
                    composite [j] = true;
                }
            }
        }


        for(int i = 0; i < 5; i++){
            int n = readInt();
            if(!composite [n]){
                System.out.println(n + " = " + n);
                continue;
            }
            if(n % 2 == 0){
                List <Integer> out = pair(n, composite);
                System.out.println(n + " = " + out.get(0) + " + " + out.get(1));
            }
            else{
                List <Integer> out = new ArrayList();
                out.add(0); out.add(0); out.add(0);
                for(int j = 3; j < 1e7+1; j+=2){
                    if(composite [j]) continue;
                    List <Integer> temp = new ArrayList();
                    temp.add(j); temp.addAll(pair(n-j, composite));
                    Collections.sort(temp);
                    out = compare(temp, out);
                }
                System.out.println(n + " = " + out.get(0) + " + " + out.get(1) + " + " + out.get(2));
            }
        }
    }
    static List <Integer> pair(int n, boolean [] composite){
        List <Integer> nums = new ArrayList();
        nums.add(0); nums.add(0);
        int l = n/2, r = n/2;
        while(l >= 0 && r <= 1e7){
            if(!composite [l] && !composite [r]){
                nums.set(0, l); nums.set(1, r);
                break;
            }
            l--; r++;
        }
        return nums;
    }
    static List <Integer> compare(List <Integer> one, List <Integer> two){
        for(int i = 0; i < 3; i++){
            if(one.get(i) > two.get(i)){
                return one;
            }
            else return two;
        }
        return one;
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