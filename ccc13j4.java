import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author richa
 */
public class TimeOnTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int time = input.nextInt();
        int chores = input.nextInt();
        int [] choreTimes = new int [chores];
        for(int i = 0; i < chores; i++){
            choreTimes [i] = input.nextInt();
        }
        Arrays.sort(choreTimes);
        int sum = 0;
        int count = 0;
        for(int i = 0; i < chores; i++){
            if(sum + choreTimes [i] <= time){
                count++;
                sum += choreTimes [i];
            }
            else{
                break;
            }
        }
        System.out.println(count);
    }
}