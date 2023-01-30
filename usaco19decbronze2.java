import java.util.*;
/**
 *
 * @author richa
 */
public class WhereAmI {

    public static boolean isValid(String mailboxes, int length){
        Map <String, Boolean> sequences = new HashMap<>();
        for(int i = 0; i <= mailboxes.length()-length; i++){
            if(sequences.containsKey(mailboxes.substring(i, i+length)))return false;
            else sequences.put(mailboxes.substring(i, i+length), true);
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String mailboxes = input.next();
        for(int i = 0; i < n; i++){
            if(isValid(mailboxes, i+1)){
                System.out.println(i+1);
                break;
            } 
        }
    }
    
}