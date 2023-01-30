import java.util.*;
/**
 *
 * @author richa
 */
public class WaitingTime {

    public static int waitTime(String [] letter, int [] number, int current){
        int count = 0;
        for(int i = 0; i < number.length; i++){
            if(letter[i].equals("R")){
                count++;
                if(number[i] == number[current]){
                    count = 0;
                }
            }
            else if(letter[i].equals("S")){
                count++;
                if(i == current){
                    return count;
                }
            }
            else{
                count += number [i]-1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String letter [] = new String [n];
        int number [] = new int [n];
        Map <Integer, Integer> times = new TreeMap<>();
        List <Integer> returned = new ArrayList<>();
        for(int i = 0; i < n; i++){
            letter [i] = input.next();
            number [i] = input.nextInt();
        }
        for(int i = 0; i < n; i++){
            if(letter [i].equals("R")){
                returned.add(number[i]);
            }
            else if(letter[i].equals("S")){
                int time = waitTime(letter, number, i);
                returned.remove((Integer) number[i]);
                if(times.containsKey(number[i])){
                    times.put(number[i], times.get(number[i])+time);
                }
                else{
                    times.put(number[i], time);
                }
            }
        }
        for(int i = 0; i < returned.size(); i++){
            times.put(returned.get(i), -1);
        }
        for(int k : times.keySet()){
            System.out.println(k + " " + times.get(k));
        }
    }
}