import java.util.*;

/**
 *
 * @author richa
 */
public class Test {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int average [] = new int [n+1];
        int petals [][] = new int [n+1][1001];
        for(int i = 1; i <= n; i++){
            int flower = input.nextInt();
            average [i] = average [i-1] + flower;
            petals [i] = petals [i-1].clone();
            petals [i][flower]++;
        }
        int count = n;
        for(int i = 1; i < n; i++){
            for(int j = i+1; j <= n; j++){
                if((average [j] - average [i-1]) % (j-i+1) == 0){
                    int wanted = (average [j] - average [i-1])/(j-i+1);
                    if(petals [j][wanted] - petals [i-1] [wanted] > 0) count++;
                }
            }
        }
        System.out.println(count);
    }
}