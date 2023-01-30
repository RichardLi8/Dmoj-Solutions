import java.util.*;
/**
 *
 * @author richa
 */
public class ModeFinding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] nums = new int [n];
        for(int i = 0; i < n; i++){
            nums [i] = input.nextInt();
        }
        Map <Integer,Integer> mode = new TreeMap<>();
        for(int i = 0; i < n; i++){
            if(mode.containsKey(nums[i])){
                mode.put(nums[i], mode.get(nums[i])+1);
            }
            else{
                mode.put(nums[i], 1);
            }
        }
        int largest = 0;
        for(int k : mode.keySet()){
            if(mode.get(k) > largest){
                largest = mode.get(k);
            }
        }
        for(int k : mode.keySet()){
            if(mode.get(k) == largest){
                System.out.print(k + " ");
            }
        }
    } 
}