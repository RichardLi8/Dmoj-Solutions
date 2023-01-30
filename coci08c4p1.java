import java.util.*;
/**
 *
 * @author richa
 */
public class Mjehuric {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] numbers = new int [5];
        int [] sorted = new int [5];
        for(int i = 0; i < 5; i++){
            numbers [i] = input.nextInt();
            sorted [i] = i+1;
        }
        while(!(Arrays.equals(numbers, sorted))){
            int temp;
            for(int i = 0; i < 4; i++){
                boolean changed = false;
                if(numbers[i]>numbers[i+1]){
                temp = numbers [i];
                numbers[i] = numbers[i+1];
                numbers[i+1] = temp;
                changed = true;
                }
                if(changed){
                    for(int j = 0; j < 5; j++){
                        System.out.print(numbers[j] + " ");
                    }
                    System.out.println("");
                }
            }
            
        }
    }
}