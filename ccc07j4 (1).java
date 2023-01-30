import java.util.*;
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
        String one = input.nextLine();
        String two = input.nextLine();
        int [] letters1 = new int [26];
        int [] letters2 = new int [26];
        for(int i = 0; i < one.length(); i++){
            if(one.charAt(i) != ' '){
                letters1 [one.charAt(i)-65]++;
            }
        }
        for(int i = 0; i < two.length(); i++){
            if(two.charAt(i) != ' '){
                letters2 [two.charAt(i)-65]++;
            }
        }
        for(int i = 0; i < 26; i++){
            if(letters1 [i] != letters2 [i]){
                System.out.println("Is not an anagram.");
                return;
            }
        }
        System.out.println("Is an anagram.");
    } 
}