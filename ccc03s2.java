import java.util.Scanner;

/**
 *
 * @author richa
 */
public class Poetry {

    public static int lastVowel(String line){
        String vowels = "aeiou";
        for(int i = line.length()-1; i >=0; i--){
            if(vowels.contains(line.substring(i, i+1))){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt(); 
        String dummy = input.nextLine();
        for(int k = 0; k < cases; k++){
            String lines [] = new String [4];
            for(int j = 0; j < 4; j++){
                lines [j] = input.nextLine().toLowerCase();
                lines [j] = lines [j].split(" ")[lines[j].split(" ").length-1];
            }
            String syllable [] = new String [4];
            for(int i = 0; i < 4; i++){
                if(lastVowel(lines [i]) != -1){
                    syllable [i] = lines [i].substring(lastVowel(lines[i]));
                }
                else{
                    syllable [i] = lines [i];
                }
            }
            if(syllable [0].equals(syllable[1]) && syllable[1].equals(syllable [2]) && syllable [2].equals(syllable [3])){
                System.out.println("perfect");
            }
            else if(syllable[0].equals(syllable[1]) && syllable [2].equals(syllable[3])){
                System.out.println("even");
            }
            else if(syllable[0].equals(syllable[2]) && syllable [1].equals(syllable[3])){
                System.out.println("cross");
            }
            else if(syllable[0].equals(syllable[3]) && syllable [1].equals(syllable[2])){
                System.out.println("shell");
            }
            else{
                System.out.println("free");
            }
        }
    } 
}