import java.util.Stack;
import java.util.Scanner;


/**
 *
 * @author richa
 */
public class Balance {

    public static boolean isBalanced(String line){
        boolean rotate = true;
        Stack <Character> stack = new Stack <>();
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == '('){
                stack.push('(');
            }
            else if(!stack.isEmpty()){
                stack.pop();
            }
            else if(rotate){
                stack.push('(');
                rotate = false;
            }
            else{
                return false;
            }
        }
        return stack.size() == 0 || (stack.size() == 2 && rotate);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        if(!line.contains("(") && !line.contains(")")){
            System.out.println("YES");
        }
        else{
            if(isBalanced(line)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}