import java.util.*;
/**
 *
 * @author richa
 */
public class GoodTimes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(n + " in Ottawa");
        System.out.println(((n-300)+2400)%2400 + " in Victoria");
        System.out.println(((n-200)+2400)%2400 + " in Edmonton");
        System.out.println(((n-100)+2400)%2400 + " in Winnipeg");
        System.out.println(n + " in Toronto");
        System.out.println((n+100)%2400 + " in Halifax");
        System.out.println((n+130-(((n+130)%100)/60)*60 + (((n+130)%100)/60)*100)%2400 + " in St. John's"); 
    }
    
}