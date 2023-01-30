import java.util.*;
/**
 *
 * @author richa
 */
public class CommonWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            int w = input.nextInt();
            int pos = input.nextInt();
            Map <String, Integer> words = new TreeMap<>();
            for(int j = 0; j < w; j++){
                String word = input.next();
                if(words.containsKey(word)){
                    words.put(word, words.get(word)+1);
                }
                else{
                    words.put(word, 1);
                }
            }
            System.out.print(pos);
            if(Integer.toString(pos).endsWith("1") && !Integer.toString(pos).endsWith("11")){
                System.out.println("st most common word(s):");
            }
            else if(Integer.toString(pos).endsWith("2") && !Integer.toString(pos).endsWith("12")){
                System.out.println("nd most common word(s):");
            }
            else if(Integer.toString(pos).endsWith("3") && !Integer.toString(pos).endsWith("13")){
                System.out.println("rd most common word(s):");
            }
            else{
                System.out.println("th most common word(s):");
            }
            Map <Integer, Integer> appearances = new TreeMap<>(Collections.reverseOrder());
            for(String k : words.keySet()){
                if(appearances.containsKey(words.get(k))){
                    appearances.put(words.get(k), appearances.get(words.get(k)) + 1);
                }
                else{
                    appearances.put(words.get(k), 1);
                }
            }
            int count = 0;
            int amount = -1;
            for(int k : appearances.keySet()){
                if(count == pos - 1){
                    amount = k;
                    break;
                }
                count += appearances.get(k);
            }
            if(amount != -1){
                for(String k : words.keySet()){
                    if(words.get(k) == amount){
                        System.out.println(k);
                    }
                }
            }
            System.out.println("");
        }
    } 
}