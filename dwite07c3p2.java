import java.util.*;
/**
 *
 * @author richa
 */
public class ThereSAnEssayInMyCode {
    static int index = 0;
    public static String Literal(String s, int i){
        String close = "";
        for(int j = i; j < s.length(); j++){
                if(s.charAt(j) == '\''){
                    close = "'";
                    index = j+1;
                    return close;
                }
                else if(s.charAt(j) == '"'){
                    close = "\"";
                    index = j+1;
                    return close;
                }
                else if(s.charAt(j) == '/'){
                    if(j < s.length()-1){
                        if(s.charAt(j+1) == '/'){
                            close = "//";
                            index = j+2;
                            return close;
                        }
                        else if(s.charAt(j+1) == '*'){
                            close = "/*";
                            index = j+2;
                            return close;
                        }
                    }
                }
            }
        return close;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < 5; i++){
            index = 0;
            String s = input.nextLine();
            String close = "";
            close = Literal(s, index);
            String line = "";
            while(index < s.length() && !close.equals("")){
                if(close.equals("'")){
                    for(int j = index; j < s.length(); j++){
                        if(s.charAt(j) == '\''){
                            line += " ";
                            index = j+1;
                            break;
                        }
                        else{
                            line += s.charAt(j);
                        }
                    }
                }
                else if(close.equals("\"")){
                    for(int j = index; j < s.length(); j++){
                        if(s.charAt(j) == '"'){
                            line += " ";
                            index = j+1;
                            break;
                        }
                        else{
                            line += s.charAt(j);
                        }
                    }
                }
                else if(close.equals("//")){
                    line += s.substring(index);
                    index = Integer.MAX_VALUE;
                }
                else if(close.equals("/*")){
                    for(int j = index; j < s.length()-1; j++){
                        if(s.substring(j, j+2).equals("*/")){
                            line += " ";
                            index = j+2;
                            break;
                        }
                        else{
                            line +=  s.charAt(j);
                        }
                    }
                }
                close = Literal(s, index);
            }
            if(line.charAt(line.length()-1) == ' '){
                System.out.println(line.substring(0, line.length()-1));
            }
            else{
                System.out.println(line);
            }
        }
    }
}