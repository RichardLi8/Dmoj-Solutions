import java.util.Scanner;
/**
 *
 * @author richa
 */
public class RotatingLetters {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String n = input.next();
        String rotatable = "IOSHZXN";
        boolean possible = true;
        for(int i = 0; i < n.length(); i++){
            if(!rotatable.contains(n.substring(i, i+1))){
                possible = false;
            }
        }
        if(possible){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
    
}