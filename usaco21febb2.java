import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class Main {
    static int [][] grid = new int [1001][1001];
    static boolean [][] cow = new boolean [1001][1001];
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            int x = input.nextInt(); int y = input.nextInt();
            cow [x][y] = true;
            if(x > 0){
                grid [x-1][y] += 1;
                if(cow [x-1][y] && grid [x-1][y] == 4) ans--;
                else if(cow [x-1][y] && grid [x-1][y] == 3) ans++;
            }
            if(x < 1000){
                grid [x+1][y] += 1;
                if(cow [x+1][y] && grid [x+1][y] == 4) ans--;
                else if(cow [x+1][y] && grid [x+1][y] == 3) ans++;
            }
            if(y > 0){
                grid [x][y-1] += 1;
                if(cow [x][y-1] && grid [x][y-1] == 4) ans--;
                else if(cow [x][y-1] && grid [x][y-1] == 3) ans++;
            }
            if(y < 1000){
                grid [x][y+1] += 1;
                if(cow [x][y+1] && grid [x][y+1] == 4) ans--;
                else if(cow [x][y+1] && grid [x][y+1] == 3) ans++;
            }
            if(grid [x][y] == 3) ans++;
            System.out.println(ans);
        }
    }
}