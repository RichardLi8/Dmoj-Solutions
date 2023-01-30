import java.util.*;
/**
 *
 * @author richa
 */
public class Boxes {

    public static int fits(int [][] available, int [] current, Map <Integer, Integer> volume){
        int size = Integer.MAX_VALUE;
        for(int i = 0; i < available.length; i++){
            if(current[0] <= available[i][0] && current [1] <= available[i][1] && current[2] <= available[i][2]){
                if(size > volume.get(i)) size = volume.get(i);
            }
                
        }
        return size;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [][] available = new int [n][3];
        Map <Integer, Integer> volume = new HashMap<>(); 
        for(int i = 0; i < n; i++){
            int current [] = new int [3];
            for(int j = 0; j < 3; j++){
                current[j] = input.nextInt();
            }
            Arrays.sort(current);
            available[i] = current;
            volume.put(i, current[0]*current[1]*current[2]);
        }
        int m = input.nextInt();
        for(int i = 0; i < m; i++){
            int current [] = new int [3];
            for(int j = 0; j < 3; j++){
                current [j] = input.nextInt();
            }
            Arrays.sort(current);
            int size = fits(available, current, volume);
            if(size == Integer.MAX_VALUE) System.out.println("Item does not fit.");
            else System.out.println(size);
        }
    }
}