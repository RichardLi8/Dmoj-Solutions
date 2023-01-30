import java.util.*;
/**
 *
 * @author richa
 */
public class CountTheTriplets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int nums [] = new int [n];
        Set <Integer> values = new HashSet <>();
        Set <String> pairs = new HashSet <>();
        for(int i = 0; i < n; i++){
            nums [i] = input.nextInt();
            values.add(nums [i]);
        }
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(values.contains(nums [i] + nums [j])) pairs.add(nums [i] + "" + nums [j]);
            }
        }
        if(!pairs.isEmpty()) System.out.println(pairs.size());
        else System.out.println("-1");
    } 
}