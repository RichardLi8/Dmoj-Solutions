import java.util.*;
/**
 *
 * @author richa
 */
public class BoringBusiness {

    static boolean safe = true;
    static boolean hole [][] = new boolean [401][201];
    static int x = 199, y = 5;
    
    public static boolean check(){
        if(hole[x][y]) return false;
        return true;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        hole [200] [1] = true;
        hole [200] [2] = true;
        hole [200] [3] = true;
        hole [201] [3] = true;
        hole [202] [3] = true;
        hole [203] [3] = true;
        hole [203] [3] = true;
        hole [203] [4] = true;
        hole [203] [5] = true;
        hole [204] [5] = true;
        hole [205] [5] = true;
        hole [205] [4] = true;
        hole [205] [3] = true;
        hole [206] [3] = true;
        hole [207] [3] = true;
        hole [207] [4] = true;
        hole [207] [5] = true;
        hole [207] [6] = true;
        hole [207] [7] = true;
        hole [206] [7] = true;
        hole [205] [7] = true;
        hole [204] [7] = true;
        hole [203] [7] = true;
        hole [202] [7] = true;
        hole [201] [7] = true;
        hole [200] [7] = true;
        hole [199] [7] = true;
        hole [199] [6] = true;
        hole [199] [5] = true;
        char direction = input.next().charAt(0);
        while(direction != 'q'){
            int distance = input.nextInt();
            if(direction == 'r'){
                for(int i = 0; i < distance; i++){
                    x++;
                    if(!check()) safe = false;
                    hole [x] [y] = true;
                }
            }
            else if(direction == 'l'){
                for(int i = 0; i < distance; i++){
                    x--;
                    if(!check()) safe = false;
                    hole [x] [y] = true;
                }
            }
            else if(direction == 'u'){
                for(int i = 0; i < distance; i++){
                    y--;
                    if(!check()) safe = false;
                    hole [x] [y] = true;
                }
            }
            else{
                for(int i = 0; i < distance; i++){
                    y++;
                    if(!check()) safe = false;
                    hole [x] [y] = true;
                }
            }
            if(!safe){
                System.out.println((x-200) + " -" + y + " DANGER");
                break;
            }
            else System.out.println((x-200) + " -" + y + " safe");
            direction = input.next().charAt(0);
        }
    }
    
}