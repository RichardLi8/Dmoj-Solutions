import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author richa
 */
public class AnagramChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line1 = input.nextLine().replace(" ", "");
        String line2 = input.nextLine().replace(" ", "");
        int letters1 [] = new int [26];
        int letters2 [] = new int [26];
        for(int i = 0; i < line1.length(); i++){
            letters1[line1.charAt(i)-65]++;
        }
        for(int i = 0; i < line2.length(); i++){
            letters2[line2.charAt(i)-65]++;
        }
        if(Arrays.equals(letters1, letters2)){
            System.out.println("Is an anagram.");
        }
        else{
            System.out.println("Is not an anagram.");
        }
    }
    
}