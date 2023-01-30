import java.util.Scanner;

/**
 *
 * @author richa
 */
public class NPuzzle {
    
    public static int findScatter(String [][] current, int x, int y, String letter){
        if(letter.equals("."))return 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(current [i][j].equals(letter)){
                    return Math.abs(x-i)+Math.abs(y-j);
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String [][] desired = {{"A","B","C","D"}, {"E","F","G","H"}, {"I", "J", "K", "L"}, {"M", "N", "O", "."}};
        String [][] current = new String [4][4];
        for(int i = 0; i < 4; i++){
            String line = input.next();
            for(int j = 0; j < 4; j++){
                current [i][j] = line.substring(j, j+1);
            }
        }
        int scatter = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                scatter += findScatter(current, i, j, desired[i][j]);
            }
        }
        System.out.println(scatter);
    }
}