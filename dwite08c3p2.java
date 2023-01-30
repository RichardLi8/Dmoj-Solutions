import java.util.Scanner;
/**
 *
 * @author richa
 */
public class WordCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String lines [] = new String [5];
        String contractions [] = {"n't", "'re", "'ve", "'ll", "'s"}; 
        String replacement [] = {" not", " are", " have", " will", " is"};
        String puncation [] = {":", ".", ";", "-", "-", "\"", ",", "/", "/", "<", ">", "(", ")", "!", "?", "@", "#", "$", "%", "&"};
        for(int i = 0; i < 5; i++){
            lines[i] = input.nextLine().toLowerCase();
            for(int j = 0; j < puncation.length; j++){
                lines[i] = lines[i].replace(puncation[j], "");
            }
            for(int j = 0; j < contractions.length; j++){
                lines[i] = lines[i].replaceAll(contractions[j], replacement[j]);
            }
        }
        for(int i = 0; i < 5; i++){
            int wordCount = 0;
            String words [] = lines[i].split(" ");
            for(int j = 0; j < words.length; j++){
                if(words[j].length() > 3){
                    wordCount++;
                }
            }
            System.out.println(wordCount);
        }
    }   
}