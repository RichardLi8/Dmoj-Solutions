import java.util.*;
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
        int n = input.nextInt();
        Stack <Integer> nums = new Stack<>();
        for(int i = 0; i < n; i++){
            int num = input.nextInt();
            if(num == 0)nums.pop();
            else nums.add(num);
        }
        if(nums.isEmpty())System.out.println("0");
        else{
            int sum = 0;
            while(!nums.isEmpty())
                sum += nums.pop();
            System.out.println(sum);
        }
    }
    
}