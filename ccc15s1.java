import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author richa
 */
public class ZeroThatOut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lines = input.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < lines; i++){
            int num = input.nextInt();
            if(num != 0){
                numbers.add(num);
            }
            else{
                numbers.remove(numbers.size()-1);
            }
        }
        int sum = 0;
        for(int i = 0; i < numbers.size(); i++){
            sum+=numbers.get(i);
        }
        System.out.println(sum);
    }
    
}