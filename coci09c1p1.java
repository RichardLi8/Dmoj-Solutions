import java.util.*;
/**
 *
 * @author richa
 */
public class Note {

    public static boolean ascend(int [] nums){
        for(int i = 1; i < 8; i++){
            if(nums [i] < nums [i-1]) return false;
        }
        return true;
    }
    public static boolean descend(int [] nums){
        for(int i = 1; i < 8; i++){
            if(nums [i] > nums [i-1]) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] nums = new int [8];
        for(int i = 0; i < 8; i++){
            nums [i] = input.nextInt();
        }
        if(ascend(nums)) System.out.println("ascending");
        else if(descend(nums)) System.out.println("descending");
        else System.out.println("mixed");
    }
    
}