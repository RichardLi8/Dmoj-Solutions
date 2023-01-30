import java.util.*;
/**
 *
 * @author richa
 */
public class ReturningHome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack <String> directions = new Stack<>();
        String line = input.nextLine();
        while(!line.equals("SCHOOL")){
           directions.add(line);
           line = input.nextLine();
        }
        while(directions.size() != 1){
            String direction = directions.pop();
            String street = directions.pop();
            if(direction.equals("R")) System.out.println("Turn LEFT onto " + street + " street.");
            else System.out.println("Turn RIGHT onto " + street + " street.");
        }
        String direction = directions.pop();
        if(direction.equals("R")) System.out.println("Turn LEFT into your HOME.");
        else System.out.println("Turn RIGHT into your HOME.");
    }
    
}