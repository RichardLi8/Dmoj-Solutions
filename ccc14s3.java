import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author richa
 */
public class GenevaConfection {

    public static boolean isPossible(Stack<Integer> mountain, Stack<Integer> branch, Stack<Integer> lake){
        while(lake.isEmpty() && !mountain.isEmpty()){    
            if(mountain.peek() == 1){
                lake.push(mountain.pop());
            }
            else{
                branch.push(mountain.pop());
            }
        }
        while(!mountain.isEmpty()){
            if(mountain.peek() == lake.peek()+1){
                lake.push(mountain.pop());
            }
            else if(!branch.isEmpty()){
                if(branch.peek() == lake.peek()+1){
                    lake.push(branch.pop());
                }
                else{
                    branch.push(mountain.pop());
                }
            }
            else{
                branch.push(mountain.pop());
            }
        }
        
        while(!branch.isEmpty()){
            if(branch.peek() == lake.peek()+1){
                lake.push(branch.pop());
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for(int k = 0; k < cases; k++){
            int cars = input.nextInt();
            Stack<Integer> mountain = new Stack<>();
            Stack<Integer> lake = new Stack<>();
            Stack<Integer> branch = new Stack<>();
            for(int i = 0; i < cars; i++){
                mountain.push(input.nextInt());
            }
            if(isPossible(mountain, branch, lake)){
                System.out.println("Y");
            }
            else{
                System.out.println("N");
            }
        }   
    } 
}