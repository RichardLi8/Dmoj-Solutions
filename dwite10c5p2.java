import java.util.*;
/**
 *
 * @author richa
 */
public class SafeFromRooks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int n = 0; n < 5; n++){
            int rows = input.nextInt();
            int cols = input.nextInt();
            int rooks = input.nextInt();
            Set <Integer> row = new HashSet<>();
            Set <Integer> col = new HashSet<>();
            for(int i = 0; i < rooks; i++){
                int x = input.nextInt();
                int y = input.nextInt();
                row.add(x);
                col.add(y);
            }
            System.out.println(rows*cols - (row.size()*cols + col.size()*rows - row.size()*col.size()));
        }
    }
}