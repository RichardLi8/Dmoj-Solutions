import java.util.*;
/**
 *
 * @author richa
 */
public class SimpleEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String header = input.nextLine();
        String message = input.nextLine();
        String replace = " !@#$%^&*,.?";
        for(int i = 0; i < message.length(); i++){
            if(replace.contains(message.substring(i, i+1))){
                message = message.substring(0, i) + message.substring(i+1);
                i--;
            }
        }
        int [] shift = new int [header.length()];
        for(int i = 0; i < header.length(); i++){
            shift [i] = header.charAt(i)-65;
        }
        int count = 0;
        for(int i = 0; i < message.length(); i++){
            int shifted = message.charAt(i)+shift[count];
            if(shifted > 90) shifted -= (shifted-65)/26 * 26;
            System.out.print((char)shifted);
            count++; 
            if(count == shift.length) count = 0;
        }
    }
    
}