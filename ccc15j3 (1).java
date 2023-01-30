import java.util.*;
/**
 *
 * @author richa
 */
public class Rövarspråket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String constant = "bcdfghjklmnpqrstvwxyz";
        String vreplace = "aaeeeiiiiooooouuuuuuu";
        String creplace = "cdfghjklmnpqrstvwxyzz";
        String changed = "";
        for(int i = 0; i < s.length(); i++){
            if(constant.contains(s.substring(i, i+1))){
                changed += s.substring(i, i+1);
                changed += vreplace.charAt(constant.indexOf(s.substring(i, i+1)));
                changed += creplace.charAt(constant.indexOf(s.substring(i, i+1)));
            }
            else{
               changed += s.substring(i, i+1);
            }
        }
        System.out.println(changed);
    }
    
}