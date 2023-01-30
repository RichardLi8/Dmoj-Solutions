import java.util.Scanner;
/**
 *
 * @author richa
 */
public class SharingIsCaring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dummyint = input.nextInt();
        int m = input.nextInt();
        int shared [] = new int [m];
        String title [] = new String [m];
        for(int i = 0; i < m; i++){
            dummyint = input.nextInt();
            shared [i] = input.nextInt();
            String dummyline = input.nextLine();
            title [i] = input.nextLine();
        }
        int n = input.nextInt();
        for(int i = 0; i < m; i++){
            if(shared[i] == n){
                System.out.println(title[i]);
            }
        }
    }
}