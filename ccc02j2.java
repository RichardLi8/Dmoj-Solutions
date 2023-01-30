import java.util.Scanner;
import java.util.ArrayList;
public class AmeriCanadian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        String word = input.next();
        String vowels = "aeiouy";
        while(!word.equals("quit!")){
            words.add(word);
            word = input.next();
        }
        for(int i = 0; i < words.size(); i++){
            if(words.get(i).contains("or") && words.get(i).length() > 3 && words.get(i).indexOf("or")+2 == words.get(i).length()){
                int index = words.get(i).indexOf("or");
                if(!vowels.contains(words.get(i).substring(index-1, index))){
                    words.set(i, words.get(i).substring(0, index)+"our");
                }
            }
        }
        for(int i = 0; i < words.size(); i++){
            System.out.println(words.get(i));
        }
    }
    
}