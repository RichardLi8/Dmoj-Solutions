import java.util.*;
/**
 *
 * @author richa
 */
public class PostfixNotation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String equation = input.nextLine();
        String characters [] = equation.split(" ");
        Stack <Double> convert = new Stack<>();
        String operaters = "+-*/%^";
        for(int i = 0; i < characters.length; i++){
            if(!operaters.contains(characters[i])){
                convert.push(Double.parseDouble(characters[i]));
            }
            else{
                double first = convert.pop();
                double second = convert.pop();
                if(characters[i].equals("+")){
                    convert.push(first+second);
                }
                else if(characters[i].equals("-")){
                    convert.push(second-first);
                }
                else if(characters[i].equals("/")){
                    convert.push(second/first);
                }
                else if(characters[i].equals("*")){
                    convert.push(first*second);
                }
                else if(characters[i].equals("%")){
                    convert.push(second%first);
                }
                else if(characters[i].equals("^")){
                    convert.push(Math.pow(second, first));
                }
            }
        }
        System.out.println(convert.pop());
    }
}