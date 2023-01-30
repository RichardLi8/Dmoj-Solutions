import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class Main {
    static Map <String, Integer> years = new HashMap();
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        years.put("Ox", 0);
        years.put("Tiger", 1);
        years.put("Rabbit", 2);
        years.put("Dragon", 3);
        years.put("Snake", 4);
        years.put("Horse", 5);
        years.put("Goat", 6);
        years.put("Monkey", 7);
        years.put("Rooster", 8);
        years.put("Dog", 9);
        years.put("Pig", 10);
        years.put("Rat", 11);
        int n = input.nextInt();
        String [] name = new String [n], adverb = new String [n], year = new String [n], otherperson = new String [n];
        for(int i = 0; i < n; i++){
           name [i] = input.next();
           input.next();
           input.next();
           adverb [i] = input.next();
           year [i] = input.next();
           input.next();
           input.next();
           otherperson [i] = input.next();
        }
        Map <String, Integer> compare = new HashMap();
        compare.put("Bessie", 0);
        Map <String, Integer> birthyear = new HashMap();
        birthyear.put("Bessie", 0);
        for(int i = 0; i < n; i++){
            if(adverb [i].equals("next")){
                int d = years.get(year [i]);
                if(d > birthyear.get(otherperson [i])){
                    d -= birthyear.get(otherperson [i]);
                    compare.put(name [i], compare.get(otherperson [i])+d);
                }
                else{
                    d = 12 - (birthyear.get(otherperson [i])-d);
                    compare.put(name [i], compare.get(otherperson [i])+d);
                }
            }
            else{
                int d = years.get(year [i]);
                if(d < birthyear.get(otherperson [i])){
                    d = birthyear.get(otherperson [i])-d;
                    compare.put(name [i], compare.get(otherperson [i])-d);
                }
                else{
                    d = 12 - (d-birthyear.get(otherperson [i]));
                    compare.put(name [i], compare.get(otherperson [i])-d);
                }
            }
            birthyear.put(name [i], years.get(year[i]));
        }
        int ans = compare.get("Bessie") - compare.get("Elsie");
        System.out.println(Math.abs(ans));
    }
}