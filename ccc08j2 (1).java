import java.util.*;
/**
 *
 * @author richa
 */
public class DoTheShuffle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int b = input.nextInt();
        int n = input.nextInt();
        List <Character> songs = new LinkedList<>();
        songs.add('A');
        songs.add('B');
        songs.add('C');
        songs.add('D');
        songs.add('E');
        while(true){
            if(b == 1){
                for(int i = 0; i < n; i++){
                    songs.add(songs.remove(0));
                }
            }
            else if(b == 2){
                for(int i = 0; i < n; i ++){
                    songs.add(0, songs.remove(4));
                }
            }
            else if(b == 3){
                for(int i = 0; i < n; i++){
                    songs.add(0, songs.remove(1));
                }
            }
            else if(b == 4){
                for(int i = 0; i < 5; i++){
                    System.out.print(songs.get(i)+" ");
                }
                break;
            }
            b = input.nextInt();
            n = input.nextInt();
        }
    }
    
}