import java.util.*;
/**
 *
 * @author richa
 */
public class Poetry {
    
    public static String syllable(String line){
        String vowel = "aeiou";
        for(int i = line.length()-1; i >= 0; i--){
            if(vowel.contains(line.substring(i, i+1))){
                return line.substring(i);
            }
        }
        return line;
    }
    
    public static boolean perfect(String syllables []){
        if(syllables [0].equals(syllables [1]) && syllables [2].equals(syllables [3]) && syllables [1].equals(syllables [2])) return true;
        return false;
    }
    
    public static boolean even(String syllables []){
        if(syllables [0].equals(syllables [1]) && syllables [2].equals(syllables [3])) return true;
        return false;
    }
    
    public static boolean cross(String syllables []){
        if(syllables [0].equals(syllables [2]) && syllables [1].equals(syllables [3])) return true;
        return false;
    }
    
    public static boolean shell(String syllables []){
        if(syllables [0].equals(syllables [3]) && syllables [1].equals(syllables [2])) return true;
        return false;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String dummy = input.nextLine();
        for(int i = 0 ; i < n; i++){
            String [] lines = new String [4];
            for(int j = 0; j < 4; j++){
                lines [j] = input.nextLine();
                lines [j] = lines[j].split(" ")[lines[j].split(" ").length-1].toLowerCase();
            }
            String syllables [] = new String [4];
            for(int j = 0; j < 4; j++){
                syllables [j] = syllable(lines [j]);
            }
            if(perfect(syllables)){
                System.out.println("perfect");
            }
            else if(even(syllables)){
                System.out.println("even");
            }
            else if(cross(syllables)){
                System.out.println("cross");
            }
            else if(shell(syllables)){
                System.out.println("shell");
            }
            else{
                System.out.println("free");
            }
        }
    }
}