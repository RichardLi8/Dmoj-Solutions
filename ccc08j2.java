import java.util.*;
/**
 *
 * @author richa
 */
public class DoTheShuffle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List <String> order = new LinkedList<>(Arrays.asList("A","B","C","D","E"));
        while(true){
            int button = input.nextInt();
            int n = input.nextInt();
            if(button == 1){
                for(int i = 0; i < n; i++){
                    order.add(order.remove(0));
                }
            }
            else if(button == 2){
                for(int i = 0; i < n; i++){
                    order.add(0,order.remove(4));
                }
            }
            else if(button == 3){
                for(int i = 0; i < n; i++){
                    order.add(0,order.remove(1));
                }
            }
            else if(button == 4){
                if(n == 1){
                    break;
                }
            }
        }
        for(int i = 0; i < 5; i++){
            System.out.print(order.get(i) + " ");
        }
    }
    
}