import java.util.*;
/**
 *
 * @author richa
 */
public class HappyOrSad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String happy = ":-)";
        String sad = ":-(";
        int nhappy = 0;
        int nsad = 0;
        for(int i = 0; i < line.length()-2; i++){
            if(line.substring(i, i+3).equals(happy)) nhappy++;
            else if(line.substring(i, i+3).equals(sad)) nsad++;
        }
        if(nhappy > nsad) System.out.println("happy");
        else if(nhappy < nsad) System.out.println("sad");
        else if(nhappy == 0) System.out.println("none");
        else System.out.println("unsure");
    }
    
}