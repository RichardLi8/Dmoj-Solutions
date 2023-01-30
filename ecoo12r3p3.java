import java.util.*;
/**
 *
 * @author richa
 */
public class SteamArithmetic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int k = 0; k < 10; k++){
            String equation = input.nextLine();
            equation = equation.replace("(", "");
            equation = equation.replace(")", "");
            String characters [] = equation.split(" ");
            Stack <Integer> convert = new Stack<>();
            String operaters = "+-*qr";
            for(int i = characters.length-1; i >= 0; i--){
                if(!operaters.contains(characters[i])){
                    convert.push(Integer.parseInt(characters[i]));
                }
                else{
                    int first = convert.pop();
                    int second = convert.pop();
                    if(characters[i].equals("+")){
                        convert.push(first+second);
                    }
                    else if(characters[i].equals("-")){
                        convert.push(first-second);
                    }
                    else if(characters[i].equals("q")){
                        convert.push(first/second);
                    }
                    else if(characters[i].equals("*")){
                        convert.push(first*second);
                    }
                    else if(characters[i].equals("r")){
                        convert.push(first%second);
                    }
                }
            }
            System.out.println(convert.pop());
            
        }
    }
}