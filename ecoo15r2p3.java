import java.util.Scanner;

/**
 *
 * @author richa
 */
public class LucasOtherTower {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            int n = input.nextInt();
            int t = input.nextInt();
            System.out.println(n*2-1);
        }
    }
}