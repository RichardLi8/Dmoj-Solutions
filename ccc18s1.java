import java.text.DecimalFormat;
import java.util.*;
/**
 *
 * @author richa
 */
public class VoronoiVillages {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double numbers [] = new double [n];
        for(int i = 0; i  < n; i++){
            numbers[i] = input.nextDouble();
        }
        Arrays.sort(numbers);
        double smallest = Integer.MAX_VALUE;
        for(int i = 1; i < n-1; i++){
            double current = 0;
            current = (numbers[i]-numbers[i-1])/2 + (numbers[i+1]-numbers[i])/2;
            if(current < smallest){
                smallest = current;
            }
        }
        System.out.println(df.format(smallest));
    }
}