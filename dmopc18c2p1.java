import java.util.*;
/**
 *
 * @author richa
 */
public class PumpkinPatches {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int smallx = Integer.MAX_VALUE, largex = Integer.MIN_VALUE, smally = Integer.MAX_VALUE, largey = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int x = input.nextInt();
            int y = input.nextInt();
            if(x < smallx) smallx = x;
            else if(x > largex) largex = x;
            if(y < smally) smally = y;
            else if(y > largey) largey = y;
        }
        System.out.println((largey-smally)*2 + (largex-smallx)*2);
    }
}