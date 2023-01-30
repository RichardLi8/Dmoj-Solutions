import java.util.*;
/**
 *
 * @author richa
 */
public class GlobalWarming {

    public static boolean matches(String one, String two){
        for(int i = 0; i < one.length() && i < two.length(); i++){
            if(one.charAt(i) != two.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while(n != 0){
            int [] tempratures = new int [n];
            for(int i = 0; i < n; i++){
                tempratures [i] = input.nextInt();
            }
            String previous = "";
            for(int i = 0; i < n-1; i++){
                previous += tempratures[i+1]-tempratures[i] + " ";
                int start = i+1;
                int end = start + i+1;
                boolean works = false;
                while(start < n-1){
                    String current = "";
                    for(int j = start; j < end && j < n-1; j++){
                        current += tempratures[j+1]-tempratures[j]+" ";
                    }
                    if(!matches(previous, current)){
                        works = false;
                        break;
                    }
                    else{
                        works = true;
                    }
                    start = end;
                    end += i+1;
                }
                if(works)break;
            }
            if(n == 1){
                System.out.println("0");
            }
            else{
                System.out.println(previous.split(" ").length);
            }
            n = input.nextInt();
        }
    }   
}