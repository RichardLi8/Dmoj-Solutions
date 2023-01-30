import java.util.*;
/**
 *
 * @author richa
 */
public class Jerseys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int j = input.nextInt();
        int a = input.nextInt();
        char [] jerseys = new char [j];
        boolean [] taken = new boolean [j];
        char [] aSize = new char [a];
        int [] aNum = new int [a];
        for(int i = 0; i < j; i++){
            jerseys [i] = input.next().charAt(0);
        }
        for(int i = 0; i < a; i++){
            aSize [i] = input.next().charAt(0);
            aNum [i] = input.nextInt();
        }
        for(int i = 0; i < a; i++){
            if(aSize [i] >= jerseys[aNum[i]-1]){
                taken [aNum[i]-1] = true;
            }
        }
        int count = 0;
        for(int i = 0; i < j; i++){
            if(taken [i]){
                count++;
            }
        }
        System.out.println(count);
    }
}