import java.util.*;
/**
 *
 * @author richa
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int dog = 0;
        int cat = 0;
        for(int i = 0; i < n; i++){
            String a = input.next();
            if(a.equals("dogs")) dog++;
            else cat++;
        }
        if(dog == cat) System.out.println("equal");
        else if(dog > cat) System.out.println("dogs");
        else System.out.println("cats");
    }
    
}