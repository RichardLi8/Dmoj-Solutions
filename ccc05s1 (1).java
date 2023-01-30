import java.util.*;
/**
 *
 * @author richa
 */
public class SnowCalls {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String letters [] = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        for(int i = 0; i < n; i++){
            String num = input.next();
            num = num.replace("-", "");
            num = num.substring(0, 10);
            String converted = "";
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 8; k++){
                    if(letters [k].contains(num.substring(j, j+1))){
                        converted += k+2;
                    }
                }
                if(converted.length() == j) converted += num.substring(j, j+1);
            }
            num = converted;
            System.out.println(num.subSequence(0, 3) + "-" + num.substring(3, 6) + "-" + num.substring(6));
        }
    }
    
}