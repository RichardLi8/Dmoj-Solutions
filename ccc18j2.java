import java.util.*;
/**
 *
 * @author richa
 */
public class OccupyParking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String dummy = input.nextLine();
        String one = input.nextLine();
        String two = input.nextLine();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(one.charAt(i) == 'C' && two.charAt(i) == 'C'){
                count++;
            }
        }
        System.out.println(count);
    }  
}