import java.util.Scanner;
/**
 *
 * @author richa
 */
public class EnglishOrFrench {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String sentences [] = new String [n];
        int T = 0;
        int S = 0;
        for(int i = 0; i < n; i++){
            sentences[i] = input.nextLine();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < sentences[i].length(); j++){
                if(sentences[i].substring(j, j+1).equalsIgnoreCase("t")){
                    T++;
                }
                else if(sentences[i].substring(j, j+1).equalsIgnoreCase("s")){
                    S++;
                }
            }
        }
        if(T > S){
            System.out.println("English");
        }
        else if(T == 0 && S == 0){
            System.out.println("English");
        }
        else{
            System.out.println("French");
        }
    }
}