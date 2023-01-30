import java.util.*;
/**
 *
 * @author richa
 */
public class GenevaConfection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for(int i = 0; i < cases; i++){
            int n = input.nextInt();
            Stack <Integer> start = new Stack<>();
            Stack <Integer> end = new Stack<>();
            Stack <Integer> side = new Stack<>();
            boolean works = true;
            for(int j = 0; j < n; j++){
                start.add(input.nextInt());
            }
            int want = 1;
            while(!start.isEmpty()){
                if(start.peek() == want){
                    end.add(start.pop());
                    want++;
                }
                else if(!side.isEmpty()){ 
                    if(side.peek() == want){
                        end.add(side.pop());
                        want++;
                    }
                    else if(start.peek() > side.peek()){
                        works = false;
                        break;
                    }
                    else{
                        side.add(start.pop());
                    }
                }
                else{
                    side.add(start.pop());
                }
            }
            if(works){
                System.out.println("Y");
            }
            else System.out.println("N");
        }
    }
    
}