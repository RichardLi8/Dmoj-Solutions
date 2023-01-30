import java.util.*;
/**
 *
 * @author richa
 */
public class ISpeakTXTMSG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        Map <String, String> phrases = new HashMap<>();
        phrases.put("CU", "see you");
        phrases.put(":-)", "I'm happy");
        phrases.put(":-(", "I'm unhappy");
        phrases.put(";-)", "wink");
        phrases.put(":-P", "stick out my tongue");
        phrases.put("(~.~)", "sleepy");
        phrases.put("TA", "totally awesome");
        phrases.put("CCC", "Canadian Computing Competition");
        phrases.put("CUZ", "because");
        phrases.put("TY", "thank-you");
        phrases.put("YW", "you're welcome");
        while(!s.equals("TTYL")){
            if(phrases.containsKey(s)) System.out.println(phrases.get(s));
            else System.out.println(s);
            s = input.next();
        }
        System.out.println("talk to you later");
    }
    
}