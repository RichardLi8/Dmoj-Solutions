import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author richa
 */
public class Email {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        for(int k = 0; k < 10; k++){
            int num = input.nextInt();
            String emails [] = new String [num];
            for(int i = 0; i < num; i++){
                emails [i] = input.next();
                emails [i] = emails[i].toLowerCase();
            }
            for(int i = 0; i < num; i++){
                int count = 0;
                while(emails[i].charAt(count) != '@'){
                    if(emails[i].charAt(count) == '.'){
                        emails [i] = emails[i].substring(0, count) + emails[i].substring(count+1, emails[i].length());
                    }
                    else if(emails[i].charAt(count) == '+'){
                        int stop = emails[i].indexOf("@");
                        emails[i] = emails[i].substring(0, count) + emails[i].substring(stop, emails[i].length());

                    }
                    else{
                        count++;
                    }
                }
            }
            Map <String, Integer> Unique = new HashMap<>();
            for(int i = 0; i < num; i++){
                if(!Unique.containsKey(emails[i])){
                    Unique.put(emails[i], 1);
                }
            }
            System.out.println(Unique.size());
        }
    }
    
}