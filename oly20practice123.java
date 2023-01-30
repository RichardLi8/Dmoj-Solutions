import java.util.*;
/**
 *
 * @author richa
 */
public class CountOddDigitNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String n = input.next();
        int count = 1;
        long ans = 0;
        String start = "1";
        String end = "9";
        while(count < n.length()){
            ans += Long.parseLong(end)-Long.parseLong(start)+1;
            start += "00";
            end += "99";
            count += 2;
        }
        if(count == n.length()){
            ans += Long.parseLong(n)-Long.parseLong(start)+1;
        }
        System.out.println(ans);
    }
    
}