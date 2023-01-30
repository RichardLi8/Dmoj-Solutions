import java.util.*;
/**
 *
 * @author richa
 */
public class UniqueElements {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] nums = new int [n];
        for(int i = 0; i < n; i++){
            nums [i] = input.nextInt();
        }
        Map <Integer, Boolean> distinct = new HashMap<>();
        for(int i = 0; i < n; i++){
            distinct.put(nums [i], true);
        }
        System.out.println(distinct.size());
    }
    
}