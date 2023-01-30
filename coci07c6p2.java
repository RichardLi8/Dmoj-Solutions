import java.util.*;
/**
 *
 * @author richa
 */
public class Semafori {

    public static int wait(int light, int red, int green, int distance){
        int time = 0;
        boolean isRed = true;
        while(time <= distance){
            if(isRed){
                time += red;
                isRed = false;
            }
            else{
                time+=green;
                isRed = true;
            }
        }
        if(isRed){
            return 0;
        }
        else{
            return time-distance;
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int l = input.nextInt();
        int [] light = new int [n];
        int [] red = new int [n];
        int [] green = new int [n];
        for(int i = 0; i < n; i++){
            light [i] = input.nextInt();
            red [i] = input.nextInt();
            green [i] = input.nextInt();
        }
        int time = 0;
        int distance = 0;
        int index = 0;
        while(distance < l){
            distance++;
            time++;
            if(index < light.length){
                if(light [index] == distance){
                    time += wait(light[index], red [index], green [index], time);
                    index++;
                }
            }
        }
        System.out.println(time);
    }
}