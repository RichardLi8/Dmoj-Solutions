import java.util.*;
/**
 *
 * @author richa
 */
public class GoingBackToTheDefinitions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String [] nums = new String [n];
        for(int i = 0; i < n; i++){
            nums [i] = input.next();
        }
        Arrays.sort(nums, new myCmp());
        for(int i = n-1; i >= 0; i--){
            System.out.print(nums [i]);
        }
    }
    
}

class myCmp implements Comparator <String>{
    public int compare(String x, String y){
        return (x+y).compareTo(y+x);
    }
}