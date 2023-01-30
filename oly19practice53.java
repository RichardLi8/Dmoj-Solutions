import java.math.BigInteger;
import java.util.*;
/**
 *
 * @author richa
 */
public class HalloweenCandy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BigInteger n = new BigInteger(input.next());
        System.out.println(n.multiply(n.add(BigInteger.ONE)).divide(BigInteger.ONE.add(BigInteger.ONE)));    
    }
        
}