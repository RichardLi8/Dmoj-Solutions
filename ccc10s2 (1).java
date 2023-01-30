import java.util.*;
/**
 *
 * @author richa
 */
public class HuffmanEncoding {

    public static String decode(String seq, Map <String, String> map){
        for(String k : map.keySet()){
            if(seq.equals(k)) return map.get(k);
        }
        return "";
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Map <String, String> map = new HashMap <>();
        for(int i = 0; i < n; i++){
            String letter = input.next();
            String num = input.next();
            map.put(num, letter);
        }
        String decode = input.next();
        String seq = "";
        for(int i = 0; i < decode.length(); i++){
            seq += decode.charAt(i);
            if(!decode(seq, map).equals("")){
                System.out.print(decode(seq, map));
                seq = "";
            }
        }
    }
    
}