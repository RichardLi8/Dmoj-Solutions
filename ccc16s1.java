import java.util.Scanner;

/**
 *
 * @author richa
 */
public class Ragaman {

    public static boolean check(int [] letters1, int [] letters2, int stars){
        int total1 = 0;
        int total2 = stars;
        for(int i = 0; i < 26; i++){
            total1 += letters1[i];
            total2 += letters2[i];
        }
        if(!(total1 == total2)){
            return false;
        }
        for(int i = 0; i < 26; i++){
            if(letters2[i] > letters1[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line1 = input.next();
        String line2 = input.next();
        int [] letters1 = new int [26]; 
        int [] letters2 = new int [26]; 
        int star = 0;
        for(int i = 0; i < line1.length(); i++){
            letters1[line1.charAt(i)-97]++;
        }
        for(int i = 0; i < line2.length(); i++){
            if(line2.charAt(i) == '*'){
                star++;
            }
            else{
                letters2[line2.charAt(i)-97]++;
            }
        }
        if(check(letters1, letters2, star)){
            System.out.println("A");
        }
        else{
            System.out.println("N");
        }
    }
    
}