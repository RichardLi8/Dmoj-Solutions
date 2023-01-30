import java.util.*;
/**
 *
 * @author richa
 */
public class Trident {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tines = input.nextInt();
        int spaces = input.nextInt();
        int handle = input.nextInt();
        for(int i = 0; i < tines; i++){
            System.out.print("*");
            for(int j = 0; j < spaces; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int j = 0; j < spaces; j++){
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for(int i = 0; i < 3 + spaces * 2; i++){
            System.out.print("*");
        }
        System.out.println("");
        for(int i = 0; i < handle; i++){
            for(int j = 0; j < spaces + 1; j++){
                System.out.print(" ");
            }
            System.out.println("*");
        }
    }
    
}