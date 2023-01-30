import java.util.*;
/**
 *
 * @author richa
 */
public class Sentences {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            int subject = input.nextInt();
            int verb = input.nextInt();
            int object = input.nextInt();
            String dummy = input.nextLine();
            String subjects [] = new String [subject];
            String verbs [] = new String [verb];
            String objects [] = new String [object];
            for(int j = 0; j < subject; j++){
                subjects [j] = input.nextLine();
            }
            for(int j = 0; j < verb; j++){
                verbs [j] = input.nextLine();
            }
            for(int j = 0; j < object; j++){
                objects [j] = input.nextLine();
            }
            for(int k = 0; k < subject; k++){
                for(int l = 0; l < verb; l++){
                    for(int m = 0; m < object; m++){
                        System.out.println(subjects [k] + " "+ verbs [l] + " " + objects [m]+".");
                    }
                }
            }
        }
    }
}