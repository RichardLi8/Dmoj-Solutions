import java.util.*;
/**
 *
 * @author richa
 */
public class CyclicShifts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String first = input.nextLine();
        String second = input.nextLine();
        boolean contains = false;
        for(int i = 0; i < second.length(); i++){
            if(first.contains(second)){
                contains = true;
                break;
            }
            else{
                second = second.substring(1) + second.substring(0,1);
            }
        }
        if(contains){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
    
}