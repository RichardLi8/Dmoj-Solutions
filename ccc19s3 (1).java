import java.io.*;
import java.util.*;
public class HelloWorld {
    static void print(int [][] g){
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 3; j++){
                System.out.print(g [i][j] + " ");
            }
            System.out.println();
        }
    }
    static boolean check(boolean a, boolean b){
        return a&b;
    }
    static boolean [][] solve(int [][] g, boolean [][] vis){
        boolean flag = true;
        boolean [][] used = new boolean [5][5];
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 3; j++){
                used [i][j] = vis [i][j];
            }
        }
        while(flag){
            flag = false;
            if(!used [1][1]){
                if(check(used [1][2], used [1][3])){
                    g [1][1] = g [1][2] * 2 - g [1][3];
                    used [1][1] = true;
                    flag = true;
                }
                else if(check(used [2][1], used [3][1])){
                    g [1][1] = g [2][1] * 2 - g [3][1];
                    used [1][1] = true;
                    flag = true;
                }
            }
            if(!used [1][2]){
                if(check(used [1][1], used [1][3])){
                    g [1][2] = (g [1][1]+g [1][3])/2;
                    used [1][2] = true;
                    flag = true;
                }
                else if(check(used [2][2], used [3][2])){
                    g [1][2] = g [2][2] * 2 - g [3][2];
                    used [1][2] = true;
                    flag = true;
                }
            }
            if(!used [1][3]){
                if(check(used [1][2], used [1][1])){
                    g [1][3] = g [1][2] * 2 - g [1][1];
                    used [1][3] = true;
                    flag = true;
                }
                else if(check(used [2][3], used [3][3])){
                    g [1][3] = g [2][3] * 2 - g [3][3];
                    used [1][3] = true;
                    flag = true;
                }
            }
            if(!used [2][1]){
                if(check(used [2][2], used [2][3])){
                    g [2][1] = g [2][2] * 2 - g [2][3];
                    used [2][1] = true;
                    flag = true;
                }
                else if(check(used [1][1], used [3][1])){
                    g [2][1] = (g [1][1]+g [3][1])/2;
                    used [2][1] = true;
                    flag = true;
                }
            }
            if(!used [2][2]){
                if(check(used [2][1], used [2][3])){
                    g [2][2] = (g [2][1]+g [2][3])/2;
                    used [2][2] = true;
                    flag = true;
                }
                else if(check(used [1][2], used [3][2])){
                    g [2][2] = (g [1][2]+g [3][2])/2;
                    used [2][2] = true;
                    flag = true;
                }
            }
            if(!used [2][3]){
                if(check(used [2][2], used [2][1])){
                    g [2][3] = g [2][2] * 2 - g [2][1];
                    used [2][3] = true;
                    flag = true;
                }
                else if(check(used [1][3], used [3][3])){
                    g [2][3] = (g [1][3]+g [3][3])/2;
                    used [2][3] = true;
                    flag = true;
                }
            }
            if(!used [3][1]){
                if(check(used [3][2], used [3][3])){
                    g [3][1] = g [3][2] * 2 - g [3][3];
                    used [3][1] = true;
                    flag = true;
                }
                else if(check(used [2][1], used [1][1])){
                    g [3][1] = g [2][1] * 2 - g [1][1];
                    used [3][1] = true;
                    flag = true;
                }
            }
            if(!used [3][2]){
                if(check(used [3][1], used [3][3])){
                    g [3][2] = (g [3][1]+g [3][3])/2;
                    used [3][2] = true;
                    flag = true;
                }
                else if(check(used [2][2], used [1][2])){
                    g [3][2] = g [2][2] * 2 - g [1][2];
                    used [3][2] = true;
                    flag = true;
                }
            }
            if(!used [3][3]){
                if(check(used [3][2], used [3][1])){
                    g [3][3] = g [3][2] * 2 - g [3][1];
                    used [3][3] = true;
                    flag = true;
                }
                else if(check(used [2][3], used [1][3])){
                    g [3][3] = g [2][3] * 2 - g [1][3];
                    used [3][3] = true;
                    flag = true;
                }
            }
        }
        return used;
    }
    static boolean works(int [][] g){
        boolean ans = true;
        ans &= (g [1][2]-g [1][1] == g [1][3]-g [1][2]);
        ans &= (g [2][2]-g [2][1] == g [2][3]-g [2][2]);
        ans &= (g [3][2]-g [3][1] == g [3][3]-g [3][2]);
        ans &= (g [2][1]-g [1][1] == g [3][1]-g [2][1]);
        ans &= (g [2][2]-g [1][2] == g [3][2]-g [2][2]);
        ans &= (g [2][3]-g [1][3] == g [3][3]-g [2][3]);
        int max = 0;
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 3; j++){
                max = Math.max(max, Math.abs(g [i][j]));
            }
        }
        return ans & max <= 1000000000;
    }
    public static void main(String [] args) throws IOException{
        int[][] g = new int [5][5]; boolean [][] vis = new boolean [5][5];
        int cnt = 0;
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 3; j++){
                String x = next();
                if(x.charAt(0) != 'X'){
                    g [i][j] = Integer.parseInt(x);
                    vis [i][j] = true;
                    cnt++;
                }
            }
        }
        if(cnt == 3){
            for(int i = 1; i <= 3; i++){
                int n = 0, v [] = new int [4];
                for(int j = 1; j <= 3; j++){
                    if(vis [i][j]){
                        n++;
                    }
                    v [j] = g [i][j];
                }
                if(n == 3){
                    for(int a = 1; a <= 3; a++){
                        for(int b = 1; b <= 3; b++){
                            g [a][b] = v [b]; 
                        }
                    }
                    print(g);
                    return;
                }
            }
            for(int j = 1; j <= 3; j++){
                int n = 0, v [] = new int [4];
                for(int i = 1; i <= 3; i++){
                    if(vis [i][j]){
                        n++;
                        v [i] = g [i][j];
                    }
                }
                if(n == 3){
                    for(int b = 1; b <= 3; b++){
                        for(int a = 1; a <= 3; a++){
                            g [a][b] = v [a]; 
                        }
                    }
                    print(g);
                    return;
                }
            }
        }
        if(cnt == 1){
            int v = 0;
            for(int i = 1; i <= 3; i++){
                for(int j = 1; j <= 3; j++){
                    if(vis [i][j]) v = g [i][j];
                }
            }
            for(int i = 1; i <= 3; i++){
                for(int j = 1; j <= 3; j++){
                    g [i][j] = v;
                }
            }
        }
        else if(cnt == 2){
            boolean [] col = new boolean [4];
            int [] v1 = new int [4];
            for(int i = 1; i <= 3; i++){
                for(int j = 1; j <= 3; j++){
                    if(vis [i][j]){
                        col [j] = true;
                        v1 [j] = g [i][j];
                    }
                }
            }
            boolean [] row = new boolean [4];
            int [] v2 = new int [4];
            for(int j = 1; j <= 3; j++){
                for(int i = 1; i <= 3; i++){
                    if(vis [i][j]){
                        row [i] = true;
                        v2 [i] = g [i][j];
                    }
                }
            }
            if(row [1] && row [2]){
                for(int j = 1; j <= 3; j++){
                    g [1][j] = v2 [1];
                    g [2][j] = v2 [2];
                    vis [1][j] = true;
                    vis [2][j] = true;
                }
            }
            else if(row [2] && row [3]){
                for(int j = 1; j <= 3; j++){
                    g [2][j] = v2 [2];
                    g [3][j] = v2 [3];
                    vis [2][j] = true;
                    vis [3][j] = true;
                }
            }
            else if(col [1] && col [2]){
                for(int i = 1; i <= 3; i++){
                    g [i][1] = v1 [1];
                    g [i][2] = v1 [2];
                    vis [i][1] = true;
                    vis [i][2] = true;
                }
            }
            else if(col [2] && col [3]){
                for(int i = 1; i <= 3; i++){
                    g [i][2] = v1 [2];
                    g [i][3] = v1 [3];
                    vis [i][2] = true;
                    vis [i][3] = true;
                }
            }
            else if(col [1] && col [3]){
                for(int i = 1; i <= 3; i++){
                    g [i][1] = v1 [1];
                    g [i][3] = v1 [3];
                    vis [i][1] = true;
                    vis [i][3] = true;
                }
            }
            else if(row [1] && row [3]){
                for(int j = 1; j <= 3; j++){
                    g [1][j] = v2 [1];
                    g [3][j] = v2 [3];
                    vis [1][j] = true;
                    vis [3][j] = true;
                }
            }
            solve(g, vis);
        }
        else if(cnt >= 3 && cnt <= 5){
            vis = solve(g, vis);
            int x = 0, y = 0;
            Outer:
            for(int i = 1; i <= 3; i++){
                for(int j = 1; j <= 3; j++){
                    if(!vis [i][j]){
                        x = i; y = j;
                        vis [i][j] = true;
                        break Outer;
                    }
                }
            }
            do{
                Random r = new Random();
                int val = r.nextInt(1000000001);
                boolean neg = r.nextBoolean();
                if(neg) val = -val;
                g [x][y] = val;
                solve(g, vis);
            }
            while(!works(g));
        }
        else solve(g, vis);
        print(g);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Integer.compare(y, p.y);
            return Integer.compare(x, p.x);
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