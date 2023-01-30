import java.util.*;
/**
 *
 * @author richa
 */
public class AttackOfTheCiphertexts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String normal = input.nextLine();
        String encrypted = input.nextLine();
        String message = input.nextLine();
        for(int i = 0; i < message.length(); i++){
            if(encrypted.contains(message.substring(i, i+1))){
                System.out.print(normal.charAt(encrypted.indexOf(message.substring(i, i+1))));
            }
            else{
                System.out.print(".");
            }
        }
    }
}