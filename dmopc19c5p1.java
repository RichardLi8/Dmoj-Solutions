import java.util.*;
/**
 *
 * @author richa
 */
public class ConspicuousCrypticChecklist {

    public static boolean works(Map <String, Boolean> have, Map <String, Boolean> need){
        for(String k : need.keySet()){
            if(!have.containsKey(k))return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int count = 0;
        String dummy = input.nextLine();
        Map <String, Boolean> have = new HashMap<>();
        for(int i = 0 ; i < n; i++){
            have.put(input.nextLine(), Boolean.TRUE);
        }
        for(int i = 0; i < m; i++){
            int k = input.nextInt();
            Map <String, Boolean> need = new HashMap<>();
            dummy = input.nextLine();
            for(int j = 0; j < k; j++){
                need.put(input.nextLine(), true);
            }
            if(works(have, need))count++;
        }
        System.out.println(count);
    }
    
}