import java.util.*;
/**
 *
 * @author richa
 */
public class MagicTrick {

    public static void number(int larger, int [] answer, boolean [] used, int current){
        for(int i = used.length-1; i >= used.length-larger-1; i--){
            if(used[i]){
                larger++;
            }
            answer [current] = i+1;
        }
        used [answer[current]-1] = true;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int k = 0; k < 5; k++){
            int n = input.nextInt();
            int larger [] = new int [n];
            for(int i = 0; i < n; i++){
                larger [i] = input.nextInt();
            }
            boolean valid = true;
            for(int i = 0; i < n; i++){
                if(larger [i] > larger.length-i-1){
                    valid = false;
                }
            }
            if(!valid){
                System.out.println("IMPOSSIBLE");
            }
            else{
                boolean used [] = new boolean [n];
                int answer [] = new int [n];
                for(int i = 0; i < n; i++){
                    number(larger [i], answer, used, i);
                }
                for(int i = 0; i < n; i++){
                    System.out.print(answer[i] + " ");
                }
                System.out.println("");
            }
        }
    }
    
}