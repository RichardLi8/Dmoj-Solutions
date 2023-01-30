import java.util.*;
/**
 *
 * @author richa
 */
public class Veci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String num = input.nextLine();
        String [] digits = num.split("");
        String largest = "";
        Arrays.sort(digits);
        for(int i = num.length()-1; i >= 0; i--){
            largest += digits [i];
        }
        if(Integer.parseInt(num) >= Integer.parseInt(largest)){
            System.out.println("0");
        }
        else{
            String current = Integer.toString(Integer.parseInt(num) + 1);
            boolean found = false;
            while(current.length() == num.length()){
                String currentDigits [] = current.split("");
                Arrays.sort(currentDigits);
                if(Arrays.equals(digits, currentDigits)){
                    found = true;
                    break;
                }
                current = Integer.toString(Integer.parseInt(current)+1);
            }
            if(found){
                System.out.println(current);
            }
            else{
                System.out.println("0");
            }
        }
        
    }
    
}