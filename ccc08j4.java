import java.util.*;


public class FromPrefixToPostfix {

    
    public static String convert(String line){
        Stack <String> equation = new Stack<>();
        for(int i = line.length()-1; i >= 0; i--){
            if(line.charAt(i) == '-' || line.charAt(i) == '+'){
                String one = equation.pop();
                String two = equation.pop();
                equation.push(one+two+line.charAt(i));
            }
            else{
                equation.push(line.substring(i, i+1));
            }
        }
        return equation.pop();
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> equations = new ArrayList<>();
        String line = input.nextLine();
        while(!line.equals("0")){
            equations.add(line.replaceAll(" ", ""));
            line = input.nextLine();
        }
        for(int i = 0; i < equations.size(); i++){
            String converted = convert(equations.get(i));
            for(int j = 0; j < converted.length(); j++){
                System.out.print(converted.charAt(j) + " ");
            }
            System.out.println("");
        }
    }
}