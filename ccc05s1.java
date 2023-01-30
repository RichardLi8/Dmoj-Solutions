import java.util.Scanner;
/**
 *
 * @author richa
 */
public class SnowCalls {

    public static String convert(String n){
        String two = "ABC";
        String three = "DEF";
        String four = "GHI";
        String five = "JKL";
        String six = "MNO";
        String seven = "PQRS";
        String eight = "TUV";
        String nine = "WXYZ";
        String converted = "";
        for(int i = 0; i < n.length(); i++){
            if(two.contains(n.substring(i, i+1))){
                converted += 2;
            }
            else if(three.contains(n.substring(i, i+1))){
                converted += 3;
            }
            else if(four.contains(n.substring(i, i+1))){
                converted += 4;
            }
            else if(five.contains(n.substring(i, i+1))){
                converted += 5;
            }
            else if(six.contains(n.substring(i, i+1))){
                converted += 6;
            }
            else if(seven.contains(n.substring(i, i+1))){
                converted += 7;
            }
            else if(eight.contains(n.substring(i, i+1))){
                converted += 8;
            }
            else if(nine.contains(n.substring(i, i+1))){
                converted += 9;
            }
            else{
                converted += n.substring(i, i+1);
            }
        }
        return converted;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        String numbers [] = new String[n];
        for(int i = 0; i < n; i++){
            numbers[i] = input.next();
            numbers[i] = numbers[i].replaceAll("-", "");
        }
        for(int i = 0; i < n; i++){
            numbers[i] = convert(numbers[i]);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(numbers[i].charAt(j));
            }
            System.out.print("-");
            for(int j = 3; j < 6; j++){
                System.out.print(numbers[i].charAt(j));
            }
            System.out.print("-");
            for(int j = 6; j < 10; j++){
                System.out.print(numbers[i].charAt(j));
            }
            System.out.println("");
        }
    }
    
}