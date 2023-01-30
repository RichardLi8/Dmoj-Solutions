import java.util.*;
/**
 *
 * @author richa
 */
public class Maternity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String parent1 = input.next();
        String parent2 = input.next();
        Set <Character> genes = new HashSet<>();
        for(int i = 0; i < 10; i+=2){
            String gene1 = parent1.substring(i, i+2);
            String gene2 = parent2.substring(i, i+2);
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    genes.add((char)(Math.min(gene1.charAt(j), gene2.charAt(k))));
                }
            }
        }
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            String baby = input.next();
            boolean isBaby = true;
            for(int j = 0; j < 5; j++){
                if(!genes.contains(baby.charAt(j))){
                    isBaby = false;
                }
            }
            if(isBaby) System.out.println("Possible baby.");
            else System.out.println("Not their baby!");
        }
    }
    
}