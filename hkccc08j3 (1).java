import java.util.*;
/**
 *
 * @author richa
 */
public class PhoneBook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Map <Integer, String> names = new HashMap<>();
        for(int i = 0; i < n; i++){
            String name = input.next();
            int number = input.nextInt();
            names.put(number, name);
        }
        int m = input.nextInt();
        Map <Integer, Integer> numbers = new TreeMap<>();
        for(int i = 0; i < m; i++){
            int number = input.nextInt();
            if(numbers.containsKey(number)){
                numbers.put(number, numbers.get(number)+1);
            }
            else{
                numbers.put(number, 1);
            }
        }
        int largest = 0;
        int number = 0;
        for(int k : numbers.keySet()){
            if(numbers.get(k) > largest){
                largest = numbers.get(k);
                number = k;
            }
        }
        System.out.println(names.get(number));
    }
    
}