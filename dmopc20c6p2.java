import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] nums1 = new int [n+1], nums2 = new int [n+1];
        int [] idx1 = new int [n+1], idx2 = new int [n+1];
        int cnt1 = 0, cnt2 = 0;
        for(int i = 1; i <= n; i++) {
            nums1 [i] = readInt();
            if(nums1 [i] == 1){
                idx1 [i] = ++cnt1;
            }
        }
        for(int i = 1; i <= n; i++) {
            nums2 [i] = readInt();
            if(nums2 [i] == 1){
                idx2 [i] = ++cnt2;
            }
        }
        if(cnt1 != cnt2){
            System.out.println(-1);
            return;
        }
        int cur1 = 0, cur2 = 0;
        for(int i = 1; i <= n; i++){
            cur1 += nums1 [i];
            cur2 += nums2 [i];
            if(cur2 > cur1){
                System.out.println(-1);
                return;
            }
        }
        int one = n, two = n, pre = n;
        List <pair> ans = new ArrayList();
        while(two != 0 && one != 0){
            if(nums2 [two] == 0) {
                two--;
                continue;
            }
            else{
                pre = two;
                while(nums2 [two-1] == 1) two--;
            }
            while(idx1 [one] != idx2 [two]) one--;
            if(one != two)ans.add(new pair(one, pre));
            two--;
        }
        System.out.println(ans.size());
        for(pair p : ans){
            System.out.println(p.st + " " + p.ed);
        }
    }
    static class pair{
        int st, ed;
        public pair(int a, int b){
            st = a;
            ed = b;
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