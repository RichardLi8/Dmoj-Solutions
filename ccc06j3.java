import java.util.*;
/**
 *
 * @author richa
 */
public class CellPhoneMessaging {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String [] numbers = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int latest;
        while(!s.equals("halt")){
            int total = 0;
            latest = -1;
            for(int i = 0; i < s.length(); i++){
                for(int j = 0; j < numbers.length; j++){
                    if(numbers [j].contains(s.substring(i, i+1))){
                        if(j == latest) total += 2;
                        latest = j;
                        total += numbers [j].indexOf(s.substring(i, i+1)) + 1;
                    }
                }
            }
            System.out.println(total);
            s = input.next();
        }
    }
    
}