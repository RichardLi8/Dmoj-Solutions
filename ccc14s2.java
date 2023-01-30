import java.util.*;
/**
 *
 * @author richa
 */
public class AssigningPartners {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String dummyline = input.nextLine();
        String one = input.nextLine();
        String two = input.nextLine();
        String partners1 [] = one.split(" ");
        String partners2 [] = two.split(" ");
        Map < String, String> pairs = new HashMap<>();
        for(int i = 0; i < n; i++){
            pairs.put(partners1[i], partners2[i]);
        }
        boolean works = true;
        for(String k : pairs.keySet()){
            if(!k.equals(pairs.get(pairs.get(k))) || k.equals(pairs.get(k))){
                works = false;
                break;
            }
        }
        if(works){
            System.out.println("good");
        }
        else{
            System.out.println("bad");
        }
    }  
}