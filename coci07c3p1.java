import java.util.*;
/**
 *
 * @author richa
 */
public class Cetiri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] nums = new int [3];
        for(int i = 0; i < 3; i++){
            nums [i] = input.nextInt();
        }
        Arrays.sort(nums);
        int first = nums[1]-nums[0];
        int second = nums[2]-nums[1];
        if(first == second){
            System.out.println(nums[2]+first);
        }
        else{
            if(first>second){
                System.out.println(nums[0]+second);
            }
            else{
                System.out.println(nums[1]+first);
            }
        }
    }
    
}