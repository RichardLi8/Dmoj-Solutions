import java.math.BigInteger;
import java.util.*;
/**
 *
 * @author richa
 */
public class BoosterCushions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int c = input.nextInt();
        int n = input.nextInt();
        List <Integer> nums = new LinkedList<>();
        for(int i = 0; i < n; i++){
            nums.add(input.nextInt());
        }
        Collections.sort(nums);
        int prev = 0;
        BigInteger sum = new BigInteger("0");
        for(int i = 0; i < c && !nums.isEmpty(); i++){
            prev = nums.remove(nums.size()-1);
            for(int j = 1; j < r && !nums.isEmpty(); j++){
                int current = nums.remove(0);
                BigInteger diff = new BigInteger(Integer.toString(prev-current+1));
                sum = sum.add(diff);
                prev++;
            }
        }
        System.out.println(sum);
    }
    
}