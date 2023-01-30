import java.util.*;
/**
 *
 * @author richa
 */
public class ARecursionProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String equation = input.nextLine();
        equation = equation.replace("(", "");
        equation = equation.replace(")", "");
        String characters [] = equation.split(" ");
        Stack <Integer> convert = new Stack<>();
        for(int i = characters.length-1; i >= 0; i--){
            if(!characters[i].equals("+")){
                convert.push(Integer.parseInt(characters[i]));
            }
            else{
                int first = convert.pop();
                int second = convert.pop();
                convert.push(first+second);
            }
        }
        System.out.println(convert.pop());
    }  
}