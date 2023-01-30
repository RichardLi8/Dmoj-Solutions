import java.util.*;

/**
 *
 * @author richa
 */
public class CrayolaLightsaber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int colours [] = new int [6];
        for(int i = 0; i < n; i++){
            String colour = input.next();
            if(colour.equals("red")){
                colours [0]++;
            }
            else if(colour.equals("orange")){
                colours [1]++;
            }
            else if(colour.equals("yellow")){
                colours [2]++;
            }
            else if(colour.equals("green")){
                colours[3]++;
            }
            else if(colour.equals("blue")){
                colours [4]++;
            }
            else{
                colours [5]++;
            }
        }
        int most = 0;
        int last = 0;
        for(int i = 0; i < 6; i++){
            if(colours [i] > most){
                last = i;
                most = colours [i];
            }
        }
        colours[last]--;
        boolean changed = true;
        int count = 1;
        while(changed){
            changed = false;
            for(int i = 0; i < 6; i++){
                if(i != last && colours [i] > 0){
                    last = i;
                    colours [i]--;
                    changed = true;
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);        
    }
}