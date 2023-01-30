import java.util.Scanner;
/**
 *
 * @author richa
 */
public class HuffmanEncoding {

    public static String containsSequence(String sequence, String letterSequences [], String letters []){
        for(int i = 0; i < letterSequences.length; i++){
            if(sequence.equals(letterSequences [i])){
                return letters [i];
            }
        }
        return "no";
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        String sequence [] = new String [k];
        String letter [] = new String [k];
        for(int i = 0; i < k; i++){
            letter[i] = input.next();
            sequence [i] = input.next();
        }
        String decode = input.next();
        String output = "";
        int index = 0;
        int endindex = 1;
        while(endindex <= decode.length()){
            if(containsSequence(decode.substring(index, endindex), sequence, letter).equals("no")){
                endindex++;
            }
            else{
                output += containsSequence(decode.substring(index, endindex), sequence, letter);
                index = endindex;
                endindex++;
            }
        }
        System.out.println(output);
    }
    
}