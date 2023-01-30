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
        int l = input.nextInt();
        String words [] = new String [n];
        for(int i = 0; i < n; i++){
            words [i] = input.next();
        }
        Arrays.sort(words, new cmp());
        for(int i = 0; i < n; i++){
            System.out.print(words [i]);
        }
    }
    
}
 class cmp implements Comparator <String>{
     public int compare(String x, String y){
         return -x.compareTo(y);
     }
 }