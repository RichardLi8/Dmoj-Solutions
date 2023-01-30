import java.util.*;
/**
 *
 * @author richa
 */
public class Maternity {

    public static void results(Set <Character> results, String [] genes1, String [] genes2){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    if(genes1[i].charAt(j) == genes2[i].charAt(k) && genes1[i].charAt(j) == 97+i) results.add((char) (97+i));
                    else results.add((char)(65+i));
                }
            }
        }
    }
    
    public static boolean possible(Set <Character> results, String baby){
        for(int i = 0; i < 5; i++){
            if(!results.contains(baby.charAt(i))) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String parent1 = input.nextLine();
        String parent2 = input.nextLine();
        String [] genes1 = new String [5];
        String [] genes2 = new String [5];
        for(int i = 0; i < 10; i+=2){
            genes1 [i/2] = parent1.substring(i, i+2);
            genes2 [i/2] = parent2.substring(i, i+2);
        }
        Set <Character> results = new HashSet<>();
        results(results, genes1, genes2);
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            String baby = input.next();
            if(possible(results, baby)) System.out.println("Possible baby.");
            else System.out.println("Not their baby!");
        }
    }
    
}