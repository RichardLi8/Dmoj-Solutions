import java.util.*;
/**
 *
 * @author richa
 */
public class Spirals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int t = input.nextInt();
        int [][] spiral = 
            {{73, 72, 71, 70, 69, 68, 67, 66, 65, 100},
            {74, 43, 42, 41, 40, 39, 38, 37, 64, 99},
            {75, 44, 21, 20, 19, 18, 17, 36, 63, 98},
            {76, 45, 22, 7, 6, 5, 16, 35, 62, 97},
            {77, 46, 23, 8, 1, 4, 15, 34, 61, 96},
            {78, 47, 24, 9, 2, 3, 14, 33, 60, 95},
            {79, 48, 25, 10, 11, 12, 13, 32, 59, 94},
            {80, 49, 26, 27, 28, 29, 30, 31, 58, 93},
            {81, 50, 51, 52, 53, 54, 55, 56, 57, 92},
            {82, 83, 84, 85, 86, 87, 88, 89, 90, 91}};
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                spiral [i][j] += n-1;
            }
        }
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(spiral [i][j] > t) spiral [i][j] = 0;
            }
        }
        String answer = "";
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(spiral [i][j] == 0) answer += "x";
                else if(spiral [i][j] > 9) answer += " " + spiral [i][j];
                else answer += "  " + spiral [i][j];
            }
            answer += "\n";
        }
        System.out.println(answer.replace("x", ""));
    }
    
}