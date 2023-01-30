import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author richa
 */
public class AttackOfTheCipherTexts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String normal = input.nextLine();
        String encoded = input.nextLine();
        String message = input.nextLine();
        String output = "";
        Map<String, String> translated = new HashMap<>();
        for(int i = 0; i < normal.length(); i++){
            translated.put(encoded.substring(i, i+1), normal.substring(i, i+1));
        }
        for(int i = 0; i < message.length(); i++){
            if(translated.containsKey(message.substring(i, i+1))){
                output += translated.get(message.substring(i, i+1));
            }
            else{
                output += ".";
            }
        }
        System.out.println(output);
    }
    
}