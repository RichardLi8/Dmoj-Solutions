import java.util.*;
/**
 *
 * @author richa
 */
public class RailwaySort {
    
    public static int index(List <Integer> current, int num){
        for(int i = 0; i < current.size(); i++){
            if(current.get(i) == num){
                return i;
            }
        }
        return -1;
    }
    
    public static boolean isConsecutive(List <Integer> current, int num){
        int n = index(current, num);
        for(int i = n+1; i < current.size(); i++){
            if(current.get(i)+1 == num){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int j = 0; j < 10; j++){
            int n = input.nextInt();
            List <Integer> current = new ArrayList<>();
            for(int i = 0; i < n; i++){
                current.add(input.nextInt());
            }
            int sum = 0;
            int num = n;
            for(int i = 0; i < n; i++){       
                if(isConsecutive(current, num)){
                    sum+=index(current, num-1);
                    current.add(0, current.remove(index(current,num-1)));
                }
                num--;
            }
            System.out.println(sum);
        }
    }
}