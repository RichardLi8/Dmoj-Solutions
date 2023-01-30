import java.util.*;
/**
 *
 * @author richa
 */
public class IconScaling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print("*");
            }
            for(int j = 0; j < n; j++){
                System.out.print("x");
            }
            for(int j = 0; j < n; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(" ");
            }
            for(int j = 0; j < n*2; j++){
                System.out.print("x");
            }
            System.out.println("");
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print("*");
            }
            for(int j = 0; j < n; j++){
                System.out.print(" ");
            }
            for(int j = 0; j < n; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
}