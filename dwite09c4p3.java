import java.util.*;
/**
 *
 * @author richa
 */
public class MovingAtTheSameTime {

    public static void move(int [] positions, int [] velocities){
        for(int i = 0; i < positions.length; i++){
            positions[i] += velocities[i];
        }
    }
    
    public static int find(int [] positions, int [] velocities, int j){
        int amount = 0;
        boolean contains = false;
        for(int i = 0; i < positions.length; i++){
            if(positions[i] == j){
                contains = true;
                amount += velocities[i];
            }
        }
        if(contains)return amount;
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String [] games = new String [5];
        for(int i = 0; i < 5; i++){
            games [i] = input.nextLine();
        }
        for(int i = 0; i < 5; i++){
            int players = games[i].replace(".", "").length();
            int positions [] = new int [players];
            int velocities [] = new int [players];
            int playerCount = 0;
            for(int j = 0; j < games[i].length(); j++){
                if(games[i].charAt(j) != '.'){
                    velocities[playerCount] = Integer.parseInt(games[i].substring(j, j+1));
                    positions[playerCount] = j;
                    playerCount++;
                }
            }
            String newboard [] = new String [games[i].length()];
            for(int j = 0; j < 5; j++){
                Arrays.fill(newboard, ".");
                for(int k = 0; k < newboard.length; k++){
                    if(find(positions, velocities, k) != -1){
                        newboard[k] = Integer.toString(find(positions, velocities,k));
                    }
                }
                for(int k = 0; k < newboard.length; k++){
                    System.out.print(newboard[k]);
                }
                System.out.println("");
                move(positions, velocities);
            }
        }
    }
    
}