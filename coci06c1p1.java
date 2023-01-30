import java.util.*;
/**
 *
 * @author richa
 */
public class Modulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] numbers = new int [10];
        for(int i = 0; i < 10; i++){
            numbers [i] = input.nextInt();
        }
        Map <Integer, Boolean> unique = new HashMap<>();
        for(int i = 0; i < 10; i++){
            if(!unique.containsKey(numbers[i]%42)){
                unique.put(numbers [i] % 42, true);
            }
        }
        System.out.println(unique.size());
    }  
}