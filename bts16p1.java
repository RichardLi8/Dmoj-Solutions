import java.util.*;
/**
 *
 * @author richa
 */
public class Harambe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int upper = 0;
        int lower = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                if(s.charAt(i) < 97){
                    upper++;
                }
                else{
                    lower++;
                }
            }
        }
        if(lower == upper){
            System.out.println(s);
        }
        else if(lower > upper){
            System.out.println(s.toLowerCase());
        }
        else{
            System.out.println(s.toUpperCase());
        }
    }   
}