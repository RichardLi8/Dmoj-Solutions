import java.util.*;
/**
 *
 * @author richa
 */
public class CheesecakeDistribution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int friends = input.nextInt();
        long [] slices = new long [friends];
        long sum = 0;
        for(int i = 0; i < friends; i++){
            slices[i] = input.nextLong();
            sum+=slices[i];
        }
        if(!(sum%friends == 0)){
            System.out.println("Impossible");
        }
        else{
            long extra = 0;
            for(int i = 0; i < friends; i++){
                if(slices [i] > sum/friends){
                    extra += slices[i] - sum/friends;
                }
            }
            System.out.println(extra);
        }
    }
    
}