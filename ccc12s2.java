import java.util.Scanner;
/**
 *
 * @author richa
 */
public class AromaticNumbers {

    public static int RomanNumeral(String letter){
        if(letter.equals("I")){
            return 1;
        }
        else if(letter.equals("V")){
            return 5;
        }
        else if(letter.equals("X")){
            return 10;
        }
        else if(letter.equals("L")){
            return 50;
        }
        else if(letter.equals("C")){
            return 100;
        }
        else if(letter.equals("D")){
            return 500;
        }
        else if(letter.equals("M")){
            return 1000;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int sum = 0;
        int [] base = new int [s.length()/2];
        int [] arabic = new int [s.length()/2];
        for(int i = 0; i < s.length(); i+=2){
            arabic [i/2] = Integer.parseInt(s.substring(i, i+1));
            base [i/2] = RomanNumeral(s.substring(i+1, i+2));
        }
        for(int i = 0; i < base.length; i++){
            if(i+1 < base.length){
                if(base[i] >= base[i+1]){
                    sum += base[i] * arabic[i];
                }
                else{
                    sum -= base[i] * arabic[i];
                }
            }
            else{
                sum += arabic[i] * base[i];
            }
        }
        System.out.println(sum);
    }
    
}