import java.util.*;
/**
 *
 * @author richa
 */
public class NotEnoughPersonnel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Teacher teachers [] = new Teacher[n];
        for(int i = 0; i < n; i++){
            teachers [i] = new Teacher(input.next(), input.nextInt());
        }
        int employees = input.nextInt();
        for(int i = 0; i < employees; i++){
            int min = input.nextInt();
            int max = input.nextInt() + min;
            Teacher current = new Teacher("No suitable teacher!", Integer.MAX_VALUE);
            for(int j = n-1; j >= 0; j--){
                if(min <= teachers [j].skill && max >= teachers [j].skill){
                    if(current.skill-min >= teachers [j].skill-min) current = teachers [j];
                }
            }
            System.out.println(current.name);
        }
    }
    
}

class Teacher{
    String name;
    int skill;
    public Teacher(String s, int n){
        name = s;
        skill = n;
    }
}