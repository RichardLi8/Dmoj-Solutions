import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        pair nums [] = new pair [n];
        for(int i = 0; i < n; i++){
            nums [i] = new pair(input.nextInt(), input.nextInt());
        }
        double ans = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < n-1; i++){
            ans = Math.max(ans, Math.abs((double)(nums [i+1].y-nums [i].y)/(nums [i+1].x-nums [i].x)));
        }
        System.out.println(ans);
    }
    static class pair implements Comparable<pair>{
        int x, y;
        public pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return Integer.compare(x, p.x);
        }
    }
}