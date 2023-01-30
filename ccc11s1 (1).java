import java.util.*;
/**
 *
 * @author richa
 */
public class EnglishOrFrench {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.next());
        int t = 0;
        int s = 0;
        for(int i = 0 ; i < n; i++){
            String line = input.nextLine();
            for(int j = 0; j < line.length(); j++){
                if(line.charAt(j) == 't' || line.charAt(j) == 'T') t++;
                else if(line.charAt(j) == 's' || line.charAt(j) == 'S') s++;
            }
        }
        if(t > s) System.out.println("English");
        else if(s == 0 && t == 0) System.out.println("English");
        else System.out.println("French");
    }
}