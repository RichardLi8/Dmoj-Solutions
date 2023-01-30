import java.util.*;
/**
 *
 * @author richa
 */
public class AssigningPartners {

    public static boolean works(Map <String, String> pair1, Map <String, String> pair2){
        for(String k : pair1.keySet()){
            if(!pair2.get(k).equals(pair1.get(k)) || k.equals(pair1.get(k))) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String [] partner1 = new String [n];
        String [] partner2 = new String [n];
        for(int i = 0; i < n; i++){
            partner1 [i] = input.next();
        }
        for(int i = 0; i < n; i++){
            partner2 [i] = input.next();
        }
        Map <String, String> pair1 = new HashMap<>();
        Map <String, String> pair2 = new HashMap<>();
        for(int i = 0; i < n; i++){
            pair1.put(partner1 [i], partner2 [i]);
            pair2.put(partner2 [i], partner1 [i]);
        }
        if(works(pair1, pair2)) System.out.println("good");
        else System.out.println("bad");
    }
}