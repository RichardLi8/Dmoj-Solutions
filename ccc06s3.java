import java.io.*;
import java.util.*;
public class HelloWorld {
    static double slope(int x1, int y1, int x2, int y2){
        return (y2-y1)*1.0/(x2-x1);
    }
    static double yint(double slope, int x, int y){
        return y-slope*x;
    }
    public static void main(String[] args) throws IOException{
        int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
        int minx = Math.min(x1, x2), maxx = Math.max(x1, x2), miny = Math.min(y1, y2), maxy = Math.max(y1, y2);
        double slope = slope(x1, y1, x2, y2), yint = yint(slope, x1, y1);
        boolean swap = false;
        if(slope == Double.NEGATIVE_INFINITY || slope == Double.POSITIVE_INFINITY){
            int temp = x1;
            x1 = y1;
            y1 = temp;
            temp = x2;
            x2 = y2;
            y2 = temp;
            swap = true;
            slope = slope(x1, y1, x2, y2); yint = yint(slope, x1, y1);
            minx = Math.min(x1, x2); maxx = Math.max(x1, x2); miny = Math.min(y1, y2); maxy = Math.max(y1, y2);
        }
        int n = readInt(), ans = 0;
        for(int i = 0; i < n; i++){
            int m = readInt();
            pair [] a = new pair [m];
            for(int j = 0; j < m; j++){
                int x = readInt(), y = readInt();
                if(swap){
                    int temp = x;
                    x = y;
                    y = temp;
                }
                a [j] = new pair(x, y);
            }
            boolean flag = false;
            for(int j = 0; j < m; j++){
                double cslope = slope(a [j].x, a [j].y, a [(j+1)%m].x, a [(j+1)%m].y), cyint = yint(cslope, a [j].x, a [j].y);
                int cminx = Math.min(a [j].x, a [(j+1)%m].x), cmaxx = Math.max(a [j].x, a [(j+1)%m].x), cminy = Math.min(a [j].y, a [(j+1)%m].y), cmaxy = Math.max(a [j].y, a [(j+1)%m].y);
                if(cslope == Double.NEGATIVE_INFINITY || cslope == Double.POSITIVE_INFINITY){
                    double y = slope*a [j].x+yint;
                    if(cminy <= y && y <= cmaxy && minx <= a [j].x && a [j].x <= maxx && miny <= y && y <= maxy){
                        flag = true;
                        break;
                    }
                }
                else if(slope == cslope){
                    if(yint == cyint){
                        if((miny <= cminy && cminy <= maxy) || (miny <= cmaxy && cmaxy <= maxy) || (miny <= cminy && cmaxy <= maxy) || (cminy <= miny && maxy <= cmaxy)){
                            flag = true;
                            break;
                        }
                    }
                }
                else{
                    double x = (cyint-yint)/(slope-cslope), y = slope*x+yint;
                    if(minx <= x && x <= maxx && miny <= y && y <= maxy && cminx <= x && x <= cmaxx && cminy <= y && y <= cmaxy){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag) ans++;
        }
        System.out.println(ans);
    }
    static class triple{
        int v, d, i;
        triple(int a, int b, int c){
            v = a;
            d = b;
            i = c;
        }
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}