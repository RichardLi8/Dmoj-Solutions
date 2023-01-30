import java.util.*;
/**
 *
 * @author richa
 */
public class BigBangSecrets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String line = input.next();
        for(int i = 1; i <= line.length(); i++){
            int shift = 3*i+n;
            int shifted = line.charAt(i-1)-shift;
            if(shifted < 65) shifted += (90-shifted)/26 * 26;
            System.out.print((char) shifted);
        }
    }
    
}