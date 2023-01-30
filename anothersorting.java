import java.util.*;
/**
 *
 * @author richa
 */
public class AnotherSorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String nums [] = new String [n];
        for(int i = 0; i < n; i++){
            nums [i] = input.next();
        }
        Arrays.sort(nums, new cmp());
        for(int i = 0; i < n; i++){
            System.out.print(nums [i] + " ");
        }
    }
    
}
class cmp implements Comparator <String>{
    public int compare(String x, String y){
        if(x.charAt(x.length()-1) != y.charAt(y.length()-1)) return Integer.compare(x.charAt(x.length()-1), y.charAt(y.length()-1));
        else{
            return -Integer.compare(Integer.parseInt(x), Integer.parseInt(y));
        }
    }
}