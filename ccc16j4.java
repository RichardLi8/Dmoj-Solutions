import java.util.*;
/**
 *
 * @author richa
 */
public class ArrivalTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String start = input.nextLine();
        int time = Integer.parseInt(start.split(":")[0])*60 + Integer.parseInt(start.split(":")[1]);
        double counter = 0;
        while(counter < 120){
            time++;
            if(time > 420 && time <= 600){
                counter += 0.5;
            }
            else if(time > 900 && time <= 1140){
                counter += 0.5;
            }
            else{
                counter++;
            }
            if(time == 1440){
                time = 0;
            }
        }
        System.out.printf("%02d:%02d", time/60, time%60);
    }
}