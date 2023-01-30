import java.util.*;
/**
 *
 * @author richa
 */
public class BobSStringOperation {

    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String one = input.nextLine();
        String two = input.nextLine();
        ArrayList <Integer> sequences1 = new ArrayList<>();
        ArrayList <Integer> sequences2 = new ArrayList<>();
        String last = "";
        int count = 0;
        for(int i = 0; i < one.length(); i++){
            if(one.substring(i, i+1).equals(last)){
                count++;
            }
            else{
                sequences1.add(count);
                count = 1;
                last = one.substring(i, i+1);
            }
        }
        last = "";
        count = 0;
        for(int i = 0; i < one.length(); i++){
            if(two.substring(i, i+1).equals(last)){
                count++;
            }
            else{
                sequences2.add(count);
                count = 1;
                last = two.substring(i, i+1);
            }
        }
        if(sequences1.size() != sequences2.size()){
            System.out.println("No");
        }
        else{
            boolean works = true;
            Map <Character, Boolean> diff1 = new HashMap<>();
            Map <Character, Boolean> diff2 = new HashMap<>();
            for(int i = 0; i < one.length(); i++){
                diff1.put(one.charAt(i), true);
                diff2.put(two.charAt(i), true);
            }
            for(int i = 0; i < sequences1.size(); i++){
                if(sequences1.get(i) != sequences2.get(i)){
                    works = false;
                    break;
                }
            }
            if(works && diff1.size() == diff2.size())System.out.println("Yes");
            else System.out.println("No");
        }
    }
}