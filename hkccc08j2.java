import java.util.Scanner;
/**
 *
 * @author richa
 */
public class LuckyNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            String num = input.next();
            while(num.length() > 1){
                int sum = 0;
                for(int j = 0; j < num.length(); j++){
                    sum += Integer.parseInt(num.substring(j, j+1));
                }
                num = Integer.toString(sum);
            }
            System.out.println(num);
        }
    }
    
}