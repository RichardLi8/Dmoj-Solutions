import java.util.*;
/**
 *
 * @author richa
 */
public class MadScientist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String want [] = input.next().split("");
        String need [] = input.next().split("");
        int chain = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!want [i].equals(need [i])){
                chain++;
            }
            else if(chain != 0){
                count++;
                chain = 0;
            }
        }
        if(chain != 0) count++;
        System.out.println(count);
    }
    
}