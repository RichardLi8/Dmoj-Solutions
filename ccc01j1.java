import java.util.Scanner;
/**
 *
 * @author richa
 */
public class DressingUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int count = 1;
        int increment = 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < count; j++){
                System.out.print("*");
            }
            for(int j = 0; j < n*2-2*count; j++){
                System.out.print(" ");
            }
            for(int j = 0; j < count; j++){
                System.out.print("*");
            }
            if(count == n){
                increment = -2;
            }
            count+=increment;
            System.out.println("");
        }
    }
    
}