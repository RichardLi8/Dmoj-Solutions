import java.util.*;
/**
 *
 * @author richa
 */
public class StackOfPresents {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] presents = new int [n];
        for(int i = 0; i < n; i++){
            presents [i] = input.nextInt();
        }
        Arrays.sort(presents);
        int current = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(presents [i] >= current){
                current += presents [i];
                count++;
            }
        }
        System.out.println(count);
    }
}