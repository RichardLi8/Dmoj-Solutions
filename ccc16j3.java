import java.util.Scanner;
/**
 *
 * @author richa
 */
public class HiddenPalindrome {

    public static boolean isPalindrome(String word){
        for(int i= 0; i < word.length()/2; i++){
            if(!(word.charAt(i) == word.charAt(word.length()-1-i))){
                return false;
            }
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.next();
        int longest = 0;
        for(int i = 0; i < word.length(); i++){
            for(int j =  word.length(); j > i; j--){
                if(isPalindrome(word.substring(i, j))){
                    if(word.substring(i, j).length() > longest){
                        longest = word.substring(i, j).length();
                    }
                }
            }
        }
        System.out.println(longest);
    }
    
}