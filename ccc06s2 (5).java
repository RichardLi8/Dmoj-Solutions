import java.util.*;
/**
 *
 * @author richa
 */
public class AttackOfTheCiphertexts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String normal = input.nextLine();
        String changed = input.nextLine();
        String encoded = input.nextLine();
        Map <String, String> mapped = new HashMap<>();
        for(int i = 0; i < normal.length(); i++){
            mapped.put(changed.substring(i, i+1), normal.substring(i, i+1));
        }
        for(int i = 0; i < encoded.length(); i++){
            if(mapped.containsKey(encoded.substring(i, i+1))){
                System.out.print(mapped.get(encoded.substring(i, i+1)));
            }
            else{
                System.out.print(".");
            }
        }
    } 
}