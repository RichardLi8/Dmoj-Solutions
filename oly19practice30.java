import java.util.*;
/**
 *
 * @author richa
 */
public class Frame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int height = input.nextInt();
        int width = input.nextInt();
        String dummy = input.nextLine();
        String [] lines = new String[height];
        for(int i = 0; i < height; i++){
            lines[i] = input.nextLine();
        }
        for(int i = 0; i < width+2; i++){
            System.out.print("#");
        }
        System.out.println("");
        for(int i = 0; i < height; i++){
            System.out.println("#" + lines[i] + "#");
        }
        for(int i = 0; i < width+2; i++){
            System.out.print("#");
        }
    }
}