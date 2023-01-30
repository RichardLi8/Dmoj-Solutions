import java.util.*;
/**
 *
 * @author richa
 */
public class MagicalMultiplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String first = input.next();
        String second = input.next();
        int sum = 0;
        for(int i = 0; i < first.length(); i++){
            for(int j = 0; j < second.length(); j++){
                sum += Integer.parseInt(first.substring(i, i+1)) * Integer.parseInt(second.substring(j, j+1));
            }
        }
        System.out.println(sum);
    }
}