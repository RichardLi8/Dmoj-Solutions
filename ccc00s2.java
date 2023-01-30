import java.util.*;
import java.text.*;
/**
 *
 * @author richa
 */
public class BabblingBrooks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0");
        int n = input.nextInt();
        List <Double> rivers = new ArrayList<>();
        for(int i = 0; i < n; i++){
            rivers.add(input.nextDouble());
        }
        int command = input.nextInt();
        while(command != 77){
            if(command == 99){
                int split = input.nextInt()-1;
                double percentage = input.nextInt();
                double removed = rivers.get(split);
                rivers.remove(split);
                double first = removed * (percentage/100);
                double second = removed - first;
                rivers.add(split, second);
                rivers.add(split, first);
            }
            else if(command == 88){
                int join = input.nextInt()-1;
                rivers.add(join, rivers.remove(join)+rivers.remove(join));
            }
            command = input.nextInt();
        }
        for(int i = 0; i < rivers.size(); i++){
            System.out.print(df.format(rivers.get(i)) + " ");
        }
    }
}