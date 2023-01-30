import java.io.*;
import java.util.*;
public class HelloWorld {
    public static int largest(int [][] psa, int x, int y){
        int l = 0, r = Math.min(n-x, m-y);
        while(l <= r){
            int mid = (l+r)/2;
            int val = psa [x+mid][y+mid] - (psa [x+mid][y-1] + psa [x-1][y+mid] - psa [x-1][y-1]);
            if(val > 0){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return r+1;
    }
    static int n, m;
    public static void main(String [] args) throws IOException{
        n = readInt(); m = readInt();
        int [][] psa = new int [n+1][m+1], grid = new int [n+1][m+1];
        for(int i = 1; i <= n; i++){
            String s = " " + next();
            for(int j = 1; j <= m; j++){
                grid [i][j] = s.charAt(j) == 'O'? 0 : 1;
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                psa [i][j] = psa [i-1][j] + psa [i][j-1] - psa [i-1][j-1] + grid [i][j];
            }
        }
        Queue <pair> q = new LinkedList();
        int [][] dist = new int [n+1][m+1];
        boolean [][] inqueue = new boolean [n+1][m+1];
        q.add(new pair(1, 1));
        dist [1][1] = largest(psa, 1, 1);
        inqueue [1][1] = true;
        while(!q.isEmpty()){
            pair p = q.poll();
            int x = p.x, y = p.y;
            inqueue [x][y] = false;
            if(x + dist [x][y] -1 == n && y + dist [x][y] -1 == m) continue;
            if(x-1 >= 1){
                int val = Math.min(dist [x][y], largest(psa, x-1, y));
                if(dist [x-1][y] < val){
                    dist [x-1][y] = val;
                    if(!inqueue [x-1][y]){
                        q.add(new pair(x-1,y));
                        inqueue [x-1][y] = true;
                    }
                }
            }
            if(x+1 <= n){
                int val = Math.min(dist [x][y], largest(psa, x+1, y));
                if(dist [x+1][y] < val){
                    dist [x+1][y] = val;
                    if(!inqueue [x+1][y]){
                        q.add(new pair(x+1,y));
                        inqueue [x+1][y] = true;
                    }
                }
            }
            if(y-1 >= 1){
                int val = Math.min(dist [x][y], largest(psa, x, y-1));
                if(dist [x][y-1] < val){
                    dist [x][y-1] = val;
                    if(!inqueue [x][y-1]){
                        q.add(new pair(x, y-1));
                        inqueue [x][y-1] = true;
                    }
                }
            }
            if(y+1 <= m){
                int val = Math.min(dist [x][y], largest(psa, x, y+1));
                if(dist [x][y+1] < val){
                    dist [x][y+1] = val;
                    if(!inqueue [x][y+1]){
                        q.add(new pair(x, y+1));
                        inqueue [x][y+1] = true;
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(i + dist [i][j] -1 == n && j + dist [i][j] -1 == m){
                    ans = Math.max(ans, dist [i][j]);
                }
            }
        }
        System.out.println(ans);
    }
    static class pair{
        int x, y;
        public pair(int a, int b){
            x = a;
            y = b;
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