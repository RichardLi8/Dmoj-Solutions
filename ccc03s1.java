import java.util.*;
/**
 *
 * @author richa
 */
public class SnakesAndLadders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] board = new int [101];
        board [54] = 19;
        board [90] = 48;
        board [99] = 77;
        board [9] = 34;
        board [40] = 64;
        board [67] = 86;
        int cur = 1;
        while(n != 0 && cur != 100){
            if(cur + n <= 100){
                cur += n;
                if(board [cur] != 0) cur = board [cur];
            }
            System.out.println("You are now on square " + cur);
            if(cur == 100){
                System.out.println("You Win!");
                return;
            }
            n = input.nextInt();
        }
        
        System.out.println("You Quit!");
    } 
}