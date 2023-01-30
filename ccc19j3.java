import java.util.*;
/**
 *
 * @author richa
 */
public class ColdCompress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String lines [] = new String [n];
        String dummy = input.nextLine();
        for(int i = 0; i < n; i++){
            lines [i] = input.nextLine();
        }
        for(int i = 0; i < n; i++){
            int count = 1;
            for(int j = 0; j < lines[i].length()-1; j++){
                if(lines[i].charAt(j) == lines[i].charAt(j+1)){
                    count++;
                }
                else{
                    System.out.print(count + " " + lines[i].charAt(j)+ " ");
                    count = 1;
                }
            }
            System.out.println(count + " " + lines[i].charAt(lines[i].length()-1));
        }
    } 
}