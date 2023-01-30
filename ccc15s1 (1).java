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
            int a = input.nextInt();
            if(a != 0){
                nums.add(a);
            }
            else{
                nums.pop();
            }
        }
        int sum = 0;
        while(!nums.isEmpty()){
            sum += nums.pop();
        }
        System.out.println(sum);
    }
    
}