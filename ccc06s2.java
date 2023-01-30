import java.util.Scanner;
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
        String Normal = input.nextLine();
        String Encoded = input.nextLine();
        String Decode = input.nextLine();
        String Translated = "";
        for(int i = 0; i < Decode.length(); i++){
            if(Encoded.contains(Decode.substring(i, i+1))){
                int index = Encoded.indexOf(Decode.substring(i, i+1));
                Translated += Normal.substring(index, index+1);
            }
            else{
                Translated += ".";
            }
        }
        System.out.println(Translated);
    }
    
}