import java.util.*;
/**
 *
 * @author richa
 */
public class MicrowaveButtons {

    public static int difference(String current [], int seconds){
        return Math.abs(seconds-getSeconds(current));
        
    }
    
    public static int getSeconds(String current[]){
        int currentSeconds = Integer.parseInt(current[0]+current[1])*3600 + Integer.parseInt(current[2]+current[3])*60 + Integer.parseInt(current[4]+current[5]);
        return currentSeconds;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String time = input.nextLine();
        int seconds = Integer.parseInt(time.split(":")[0]) * 3600 + Integer.parseInt(time.split(":")[1]) * 60 + Integer.parseInt(time.split(":")[2]);
        String buttons = input.nextLine();
        String best = buttons.substring(0,1)+buttons.substring(0,1)+":"+buttons.substring(0,1)+buttons.substring(0,1)+":"+buttons.substring(0,1)+buttons.substring(0,1);
        int bestTime = 0;
        String [] current = new String [6];
        for(int i = 0; i  < buttons.length(); i++){
            current [0] = buttons.substring(i, i+1);
            for(int j = 0; j < buttons.length(); j++){
                current [1] = buttons.substring(j, j+1);
                for(int k = 0; k < buttons.length(); k++){
                    current[2] = buttons.substring(k, k+1);
                    for(int l = 0; l < buttons.length(); l++){
                        current[3] = buttons.substring(l, l+1);
                        for(int n = 0; n < buttons.length(); n++){
                            current[4] = buttons.substring(n, n+1);
                            for(int m = 0; m < buttons.length(); m++){
                                current[5] = buttons.substring(m, m+1);
                                if(Math.abs(seconds-bestTime) > Math.abs(difference(current, seconds))){
                                    bestTime = getSeconds(current);
                                    best = current[0]+current[1]+":"+current[2]+current[3]+":"+current[4]+current[5];
                                    if(getSeconds(current) == seconds){
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(best);
        
    }
}