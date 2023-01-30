import java.util.*;
/**
 *
 * @author richa
 */
public class SpreadsheetSorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int c = input.nextInt();
        String [] rows = new String [r];
        String dummy = input.nextLine();
        for(int i = 0; i < r; i++){
            rows [i] = input.nextLine();
        }
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            int col = input.nextInt();
            Arrays.sort(rows, new myCmp(col));
        }
        for(int i = 0; i < r; i++){
            System.out.println(rows [i]);
        }
    }
}

class myCmp implements Comparator <String>{
    int col = -1;
    public myCmp(int col){
        this.col = col;
    }
    public int compare(String x, String y){
        String col1 [] = x.split(" ");
        String col2 [] = y.split(" ");
        return Integer.compare(Integer.parseInt(col1 [col-1]), Integer.parseInt(col2 [col-1]));
    }
}