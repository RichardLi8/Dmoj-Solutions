import java.util.*;
/**
 *
 * @author richa
 */
public class BobSExpressionEvaluation {

    public static int calcPostfix(String equation){
        Stack <Integer> sum = new Stack<>();
        String operators = "+-*/%";
        for(int i = 0; i < equation.length(); i++){
            if(operators.contains(equation.substring(i, i+1))){
                int one = sum.pop();
                int two = sum.pop();
                if(equation.charAt(i) == '+'){
                    sum.push(one+two);
                }
                else if(equation.charAt(i) == '-'){
                    sum.push(two-one);
                }
                else if(equation.charAt(i) == '*'){
                    sum.push(one*two);
                }
                else if(equation.charAt(i) == '/'){
                    sum.push(two/one);
                }
                else if(equation.charAt(i) == '%'){
                    sum.push(two%one);
                }
            }
            else{
                sum.push(Integer.parseInt(equation.substring(i, i+1)));
            }
        }
        return sum.pop();
    }
    
    public static int calcPrefix(String equation){
        Stack <Integer> sum = new Stack<>();
        String operators = "+-*/%";
        for(int i = equation.length()-1; i >= 0; i--){
            if(operators.contains(equation.substring(i, i+1))){
                int one = sum.pop();
                int two = sum.pop();
                if(equation.charAt(i) == '+'){
                    sum.push(one+two);
                }
                else if(equation.charAt(i) == '-'){
                    sum.push(one-two);
                }
                else if(equation.charAt(i) == '*'){
                    sum.push(one*two);
                }
                else if(equation.charAt(i) == '/'){
                    sum.push(one/two);
                }
                else if(equation.charAt(i) == '%'){
                    sum.push(one%two);
                }
            }
            else{
                sum.push(Integer.parseInt(equation.substring(i, i+1)));
            }
        }
        return sum.pop();
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String equations [] = new String [5];
        int answers [] = new int [5];
        for(int i = 0; i < 5; i++){
            equations [i] = input.nextLine().replace(" ", "");
        }
        String operators = "+-*/%";
        for(int i = 0; i < 5; i++){
            if(operators.contains(equations[i].substring(0, 1))){
                answers[i] = calcPrefix(equations[i]);
            }
            else{
                answers[i] = calcPostfix(equations[i]);
            }
                    
        }
        for(int i = 0; i < 5; i++){
            System.out.println(answers[i]);
        }
    }  
}