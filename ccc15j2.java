import java.util.Scanner;
/**
 *
 * @author richa
 */
public class HappyOrSad {

    public static boolean isHappy(String n, int count){
        String face = "";
        if(n.length()-count >= 3){
            for(int i = count; i < count+3; i++){
                face += n.substring(i, i+1);
            }
            if(face.equals(":-)")){
                return true;
            }
        }
            return false;
    }
    
    public static boolean isSad(String n, int count){
        String face = "";
        if(n.length()-count >= 3){
            for(int i = count; i < count+3; i++){
                face += n.substring(i, i+1);
            }
            if(face.equals(":-(")){
                return true;
            }
        }
            return false;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int sad = 0;
        int happy = 0;
        int count = 0;
        while(count < line.length()){
            if(line.charAt(count) == ':'){
                if(isHappy(line, count)){
                    happy++;
                    count+=2;
                }
                else if(isSad(line, count)){
                    sad++;
                    count+=2;
                }
            }
            count++;
        }
        if(happy > sad){
            System.out.println("happy");
        }
        else if(sad > happy){
            System.out.println("sad");
        }
        else if(sad == 0 && happy == 0){
            System.out.println("none");
        }
        else{
            System.out.println("unsure");
        }
    }
    
}