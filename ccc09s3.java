import java.io.*;
import java.util.*;
public class HelloWorld {
    static boolean [][] friends = new boolean [50][50];
    public static void main(String [] args) throws IOException{
        friends [1][6] = true; friends [6][1] = true;
        friends [2][6] = true; friends [6][2] = true;
        friends [3][6] = true; friends [6][3] = true;
        friends [7][6] = true; friends [6][7] = true;
        friends [3][4] = true; friends [4][3] = true;
        friends [4][5] = true; friends [5][4] = true;
        friends [4][6] = true; friends [6][4] = true;
        friends [5][6] = true; friends [6][5] = true;
        friends [3][5] = true; friends [3][5] = true;
        friends [7][8] = true; friends [8][7] = true;
        friends [8][9] = true; friends [9][8] = true;
        friends [9][10] = true; friends [10][9] = true;
        friends [11][10] = true; friends [10][11] = true;
        friends [9][12] = true; friends [12][9] = true;
        friends [11][12] = true; friends [12][11] = true;
        friends [3][15] = true; friends [15][3] = true;
        friends [15][13] = true; friends [13][15] = true;
        friends [12][13] = true; friends [13][12] = true;
        friends [13][14] = true; friends [14][13] = true;
        friends [16][17] = true; friends [17][16] = true;
        friends [18][16] = true; friends [16][18] = true;
        friends [17][18] = true; friends [18][17] = true;
        char cmd = next().charAt(0);
        while(cmd != 'q'){
            if(cmd == 'i'){
                int x = readInt(), y = readInt();
                friends [x][y] = true; friends [y][x] = true;
            }
            else if(cmd == 'd'){
                int x = readInt(), y = readInt();
                friends [x][y] = false; friends [y][x] = false;
            }
            else if(cmd == 'n'){
                int dist [] = dist(readInt());
                int ans = 0;
                for(int i = 1; i < 50; i++){
                    if(dist [i] == 1) ans++;
                }
                System.out.println(ans);
            }
            else if(cmd == 'f'){
                int dist [] = dist(readInt());
                int ans = 0;
                for(int i = 1; i < 50; i++){
                    if(dist [i] == 2) ans++;
                }
                System.out.println(ans);
            }
            else if(cmd == 's'){
                int dist [] = dist(readInt());
                int des = readInt();
                System.out.println(dist [des] == 1e9 ? "Not connected" : dist [des]);
            }
            cmd = next().charAt(0);
        }
    }
    static int [] dist (int src){
        int dist [] = new int [50];
        Arrays.fill(dist, (int)1e9);
        Queue <Integer> q = new LinkedList();
        q.add(src); dist [src] = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            for(int i = 1; i < 50; i++){
                if(friends [u][i] && dist [i] == 1e9){
                    dist [i] = dist [u] + 1;
                    q.add(i);
                }
            }
        }
        return dist;
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