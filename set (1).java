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
        Map <Integer, Boolean> unique = new HashMap<>();
        for(int i = 0; i < n; i++){
            unique.put(input.nextInt(), Boolean.TRUE);
        }
        System.out.println(unique.size());
    }
    
}