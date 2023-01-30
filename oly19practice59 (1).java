import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author richa
 */
public class MostPopularNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Map<Integer, Integer> numbers = new HashMap<>();
        for(int i = 0; i < n; i++){
            int num = input.nextInt();
            if(numbers.containsKey(num)){
                numbers.put(num, numbers.get(num)+1);
            }
            else{
                numbers.put(num, 1);
            }
        }
        int smallest = Integer.MAX_VALUE;
        int most = 0;
        for(int k : numbers.keySet()){
            if(numbers.get(k) > most){
                most = numbers.get(k);
                smallest = k;
            }
            else if(numbers.get(k) >= most){
                if(k < smallest){
                    smallest = k;
                }
            }
        }
        System.out.println(smallest);
    }
    
}