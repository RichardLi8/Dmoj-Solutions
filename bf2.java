import java.util.Scanner;
/**
 *
 * @author richa
 */
public class LexicographicallyLeastSubstring {
    
    public static boolean isSmaller(String str1, String str2){
        for(int i = 0; i < str1.length() && i < str2.length(); i++){
            if(str1.charAt(i) < str2.charAt(i)){
                return true;
            }
            else if(str1.charAt(i) > str2.charAt(i)){
                return false;
            }
        }
        return false;
    }
    
    public static void sort(String [] sub){
        for(int i = 0; i < sub.length-1; i++) 
            for(int j = 0; j < sub.length-i-1; j++) 
                if(!isSmaller(sub[j], sub[j+1])) 
                {
                    String temp = sub[j]; 
                    sub[j] = sub[j+1]; 
                    sub[j+1] = temp; 
                } 
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.next();
        int n = input.nextInt();
        String sub [] = new String [line.length()-n];
        for(int i = 0; i < line.length()-n; i++){
            sub [i] = line.substring(i, i+n);
        }
        sort(sub);
        System.out.println(sub[0]);
    }
    
}