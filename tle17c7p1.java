import java.util.*;
/**
 *
 * @author richa
 */
public class Stargazing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] planetx = new int [n+1];
        int [] planety = new int [n+1];
        int count = 1;
        planetx [1] = 0;
        planety [1] = 0;
        boolean plane [][] = new boolean [4001][4001];
        plane [2000][2000] = true;
        for(int i = 2; i <= n; i++){
            int planet = input.nextInt();
            int x = input.nextInt();
            int y = input.nextInt();
            planetx [i] = planetx [planet] + x;
            planety [i] = planety [planet] + y;
            if(!plane [planetx [i] + 2000] [planety [i] + 2000]){
                count++;
                plane [planetx [i] + 2000] [planety [i] + 2000] = true;
            }
        }
        System.out.println(count);
    }
}