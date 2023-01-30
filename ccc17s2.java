import java.util.*;
/**
 *
 * @author richa
 */
public class HighTideLowTide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int tides [] = new int [n];
        for(int i = 0; i < n; i++){
            tides [i] = input.nextInt();
        }
        Arrays.sort(tides);
        if(n%2 == 0){
            for(int i = 0; i < n/2; i++){
                System.out.print(tides [n/2-1-i] + " " + tides [n/2+i] + " ");
            }
        }
        else{
            for(int i = 0; i < n/2; i++){
                System.out.print(tides [n/2-i] + " " + tides [n/2+1+i] + " ");
            }
            System.out.print(tides[0]);
        }
    }
}