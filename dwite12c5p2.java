import java.util.*;
/**
 *
 * @author richa
 */
public class CopycatSMS {

    public static int overlap(String s){
        int count = 0;
        for(int i = s.length()-2; i > 0; i--){
            count++;
            if(s.endsWith(s.substring(0, i))){
                return s.length()-count-1;
            }
        }
        return s.length()-count-2;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < 5; i++){
            String s = input.nextLine();
            overlap(s);
            System.out.println(s+s.substring(overlap(s)));
        }
    }
    
}