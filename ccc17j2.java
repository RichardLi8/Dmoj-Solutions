import java.util.Scanner;
/**
 *
 * @author richa
 */
public class ShiftySum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int sum = n;
        for(int i = 0; i < k; i++){
            sum += n*Math.pow(10,(i+1));
        }
        System.out.println(sum);
    }
    
}