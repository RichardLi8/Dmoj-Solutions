import java.util.*;
/**
 *
 * @author richa
 */
public class PartyInvitation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List <Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        int k = input.nextInt();
        for(int i = 0; i < k; i++){
            int a = input.nextInt();
            List <Integer> changed = new ArrayList<>();
            for(int j = 0; j < nums.size(); j++){
                if((j+1)%a != 0){
                    changed.add(nums.get(j));
                }
            }
            nums = changed;
        }
        for(int i = 0; i < nums.size(); i++){
            System.out.println(nums.get(i));
        }
    }
}