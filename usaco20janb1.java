import java.util.*;
/**
 *
 * @author richa
 */
public class WordProcessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int l = input.nextInt();
        String d = input.nextLine();
        String words [] = input.nextLine().split(" ");
        int count = 0;
        for(int i = 0; i < n; i++){
            if(count + words [i].length() > l){
                System.out.println("");
                count = 0;
            }
            if(count == 0){
                count += words [i].length();
                System.out.print(words [i]);
            }
            else{
                count += words [i].length();
                System.out.print(" " + words [i]);
            }
        }
        System.out.println("");
    }
    
}