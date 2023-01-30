import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author richa
 */
public class AllBalanced {

    public static boolean isValid(String line){
        Stack <Character> order = new Stack<>();
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == '(' || line.charAt(i) == ')' || line.charAt(i) == '[' || line.charAt(i) == ']' || line.charAt(i) == '{' || line.charAt(i) == '}'){
                if(line.charAt(i) == '('){
                    order.push('(');
                }
                else if(line.charAt(i) == ')'){
                    if(!order.isEmpty()){
                        if(!(order.pop() == '(')){
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
                
                else if(line.charAt(i) == '['){
                    order.push('[');
                }
                else if(line.charAt(i) == ']'){
                    if(!order.isEmpty()){
                        if(!(order.pop() == '[')){
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
                
                else if(line.charAt(i) == '{'){
                    order.push('{');
                }
                else if(line.charAt(i) == '}'){
                    if(!order.isEmpty()){
                        if(!(order.pop() == '{')){
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return order.isEmpty();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String lines [] = new String [5];
        for(int i = 0; i < 5; i++){
            lines [i] = input.nextLine();
        }
        for(int i = 0; i < 5; i++){
            if(isValid(lines[i])){
                System.out.println("balanced");
            }
            else{
                System.out.println("not balanced");
            }
        }
    }   
}