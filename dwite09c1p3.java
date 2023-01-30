import java.util.Scanner;
/**
 *
 * @author richa
 */
public class ThatMissingNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < 5; i++){
            int n = input.nextInt();
            int [] nums = new int [n];
            for(int j = 0; j < n; j++){
                nums [j] = input.nextInt();
            }
            boolean found [] = new boolean [n+2];
            for(int j = 0; j < n; j++){
                found [nums[j]] = true;
            }
            int missing = -1;
            for(int j = 1; j <= n+1; j++){
                if(!found[j]){
                    missing = j;
                }
            }
            System.out.println(missing);
        }
    }
    
}