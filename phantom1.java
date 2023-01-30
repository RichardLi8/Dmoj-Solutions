import java.util.*;
/**
 *
 * @author richa
 */
public class TheMirror {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            int start = input.nextInt();
            int end = input.nextInt();
            int count = 0;
            if(start <  2) start = 2;
            for(int j = start; j < end; j++){
                boolean prime = true;
                for(int k = 2; k <= Math.sqrt(j); k++){
                    if(j % k == 0){
                        prime = false;
                        break;
                    }
                }
                if(prime) count++;
            }
            System.out.println(count);
        }
    }
    
}