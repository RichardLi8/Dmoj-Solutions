import java.util.Scanner;
/**
 *
 * @author richa
 */
public class DNAOrRNA {

    public static boolean containsIllegal(String genetic){
        String illegal = "BDEFHIJKLMNOPQRSVWXYZ";
        for(int i = 0; i < genetic.length(); i++){
            if(illegal.contains(genetic.substring(i, i+ 1))){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String genetic = input.next();
        if(containsIllegal(genetic) || (genetic.contains("T") && genetic.contains("U"))){
            System.out.println("neither");
        }
        else if(genetic.contains("T")){
            System.out.println("DNA");
        }
        else if(genetic.contains("U")){
            System.out.println("RNA");
        }
        else{
            System.out.println("both");
        }
        
    }
    
}