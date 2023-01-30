import java.util.*;
/**
 *
 * @author richa
 */
public class TandemBicycle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        int n = input.nextInt();
        Integer [] dmoj = new Integer [n];
        Integer [] peg = new Integer [n];
        for(int i = 0; i < n; i++){
            dmoj [i] = input.nextInt();
        }
        for(int i = 0; i < n; i++){
            peg [i] = input.nextInt();
        }
        if(q == 1){
            Arrays.sort(dmoj);
            Arrays.sort(peg);
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += Integer.max(dmoj [i], peg [i]);
            }
            System.out.println(sum);
        }
        else{
            Arrays.sort(dmoj);
            Arrays.sort(peg, new cmp());
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += Integer.max(dmoj [i], peg [i]);
            }
            System.out.println(sum);
        }
    }
    
}

class cmp implements Comparator <Integer>{
    public int compare(Integer x, Integer y){
        return -Integer.compare(x, y);
    }
}