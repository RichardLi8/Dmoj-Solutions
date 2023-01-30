import java.util.*;
/**
 *
 * @author richa
 */
public class From1987to2013 {

    public static int distinctYear(int year){
        Map <Character, Integer> digits = new HashMap<>();
        String date = "";
        date += year+1;
        while(true){
            digits.clear();
            for(int i = 0; i < date.length(); i++){
                if(!digits.containsKey(date.charAt(i))){
                    digits.put(date.charAt(i), 1);
                }
                else{
                    digits.put(date.charAt(i), digits.get(date.charAt(i)) + 1);
                }
            }
            if(digits.size() == date.length()) return Integer.parseInt(date);
            date = Integer.toString(Integer.parseInt(date)+1);
        }
        
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        System.out.println(distinctYear(year));
    }
    
}