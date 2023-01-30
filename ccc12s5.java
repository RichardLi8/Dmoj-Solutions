import java.util.Scanner;
/**
 *
 * @author richa
 */
public class MouseJourney {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int col = input.nextInt();
        int [][] cage = new int [row+ 1][col + 1];
        boolean [][] isTaken = new boolean [row + 1][col + 1];
        cage [1][1] = 1;
        isTaken [1][1] = true;
        int cats = input.nextInt();
        for(int i = 0; i < cats; i++){
            int x = input.nextInt();
            int y = input.nextInt();
            isTaken [x][y] = true;
        }
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(!isTaken [i][j]){
                    cage[i][j] = cage[i-1][j] + cage[i][j-1];
                }
            }
        }
        System.out.println(cage[row][col]);
    }
}