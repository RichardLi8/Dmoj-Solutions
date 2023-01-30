import java.util.*;
/**
 *
 * @author richa
 */
public class BobSMedian {

    public static boolean larger(String one, String two){
        for(int i = 0; i < one.length() && i < two.length(); i++){
            if(one.charAt(i) < two.charAt(i)){
                return true;
            }
        }
        if(one.length() < two.length()){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String dummy = input.nextLine();
        Map <String, Integer> names = new TreeMap<>();
        int marks [] = new int[n];
        for(int i = 0; i < n; i++){
            String name = input.next();
            int mark = input.nextInt();
            names.put(name, mark);
            marks [i] = mark;
        }
        Arrays.sort(marks);
        int median = marks[n/2];
        String winner = "";
        for(String k : names.keySet()){
            if(names.get(k) == median && larger(winner, k)){
                winner = k;
            }
        }
        System.out.println(winner);
    }
}