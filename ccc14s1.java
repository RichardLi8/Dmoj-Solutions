import java.util.*;
/**
 *
 * @author richa
 */
public class PartyInvitation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        List <Integer> friends = new ArrayList<>();
        for(int i = 1; i <= k; i++){
            friends.add(i);
        }
        int m = input.nextInt();
        int [] remove = new int [m];
        for(int i = 0; i < m; i++){
            remove [i] = input.nextInt();
        }
        for(int i = 0; i < m; i++){
            List <Integer> temp = new ArrayList<>();
            while(!friends.isEmpty()){
                temp.add(friends.remove(0));
            }
            for(int j = 0; j < temp.size(); j++){
                if((j+1)%remove[i] != 0){
                    friends.add(temp.get(j));
                }
            }
        }
        for(int i = 0; i < friends.size(); i++){
            System.out.println(friends.get(i));
        }    
    }
}