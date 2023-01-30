import java.util.*;

public class HelloWorld {
    
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String dummy = input.nextLine();
        for(int i = 0; i < n; i++){
            int replace = input.nextInt();
            String line = input.nextLine();
            String letters [] = line.split("");
            System.out.print(i+1 + " ");
            for(int j = 1; j < letters.length; j++){
                if(j != replace){
                    System.out.print(letters [j]);
                }
            }
            System.out.println();
        }
    }
}