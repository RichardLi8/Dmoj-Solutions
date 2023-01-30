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
        String dummy = input.nextLine();
        String [] people = new String [n];
        int [] numbers = new int [n];
        for(int i = 0; i < n; i++){
            people[i] = input.next();
            numbers [i] = input.nextInt();
        }
        int a = input.nextInt();
        Map <Integer, Integer> amount = new HashMap<>();
        for(int i = 0; i < a; i++){
            int number = input.nextInt();
            if(amount.containsKey(number)){
                amount.put(number, amount.get(number)+1);
            }
            else{
                amount.put(number, 1);
            }
        }
        int largest = 0;
        int number = Integer.MAX_VALUE;
        for(int k : amount.keySet()){
            if(amount.get(k) > largest){
                largest = amount.get(k);
                number = k;
            }
            else if(amount.get(k) == largest && number > k){
                number = k;
            }
        }
        for(int i = 0; i < n; i++){
            if(numbers[i] == number){
                System.out.println(people[i]);
                break;
            }
        }
    }
}