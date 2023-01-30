import java.util.*;
/**
 *
 * @author richa
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int letters [] = new int [26];
        for(int i = 0; i < s.length(); i++){
            letters [s.charAt(i)-'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(letters [i]%2 != 0){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    
}