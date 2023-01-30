import java.util.Scanner;
/**
 *
 * @author richa
 */
public class WhenInRome {
    public static String convertToRoman(int num){
        String converted = "";
        String num1 = Integer.toString(num);
        if(num == 1000){
            return "M";
        }
        int hundreds = 0;
        while(num-100>= 0){
            hundreds++;
            num-=100;
        }
        int tens = 0;
        while(num-10>= 0){
            tens++;
            num-=10;
        }
        int ones = 0;
        while(num-1>= 0){
            ones++;
            num-=1;
        }
        
        if(hundreds == 9){
            converted+= "CM";
        }
        else if(hundreds == 5){
            converted += "D";
        }
        else if(hundreds == 4){
            converted += "CD";
        }
        else{
            if(hundreds > 5){
                converted += "D";
                hundreds-=5;
                for(int i = 0; i < hundreds; i++){
                    converted+="C";
                }
            }
            else{
                for(int i = 0; i < hundreds; i++){
                    converted+="C";
                }
            }
        }
        
        if(tens == 9){
            converted += "XC";
        }
        else if(tens == 5){
            converted += "L";
        }
        else if(tens == 4){
            converted += "XL";
        }
        else{
            if(tens > 5){
                converted += "L";
                tens-=5;
                for(int i = 0; i < tens; i++){
                    converted+="X";
                }
            }
            else{
                for(int i = 0; i < tens; i++){
                    converted+="X";
                }
            }
        }
        
        if(ones == 9){
            converted += "IX";
        }
        else if(ones == 5){
            converted += "V";
        }
        else if(ones == 4){
            converted += "IV";
        }
        else{
            if(ones > 5){
                converted += "V";
                ones-=5;
                for(int i = 0; i < ones; i++){
                    converted+="I";
                }
            }
            else{
                for(int i = 0; i < ones; i++){
                    converted+="I";
                }
            }
        }
        return converted;
    }
    public static int convertToInt(String num){
        int converted = 0;
        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i) == 'I'){
                if(i < num.length()-1){
                    if(num.charAt(i+1) == 'V'){
                        converted += 4;
                        i++;
                    }
                    else if(num.charAt(i+1) == 'X'){
                        converted += 9;
                        i++;
                    }
                    else{
                        converted++;
                    }
                }
                else{
                    converted++;
                }
            }
            else if(num.charAt(i) == 'X'){
                 if(i < num.length()-1){
                    if(num.charAt(i+1) == 'L'){
                        converted += 40;
                        i++;
                    }
                    else if(num.charAt(i+1) == 'C'){
                        converted += 90;
                        i++;
                    }
                    else{
                        converted+=10;
                    }
                }
                else{
                    converted+=10;
                }
            }
            else if(num.charAt(i) == 'V'){
                converted+=5;
            }
            else if(num.charAt(i) == 'L'){
                converted+=50;
            }
            else if(num.charAt(i) == 'C'){
                 if(i < num.length()-1){
                    if(num.charAt(i+1) == 'D'){
                        converted += 400;
                        i++;
                    }
                    else if(num.charAt(i+1) == 'M'){
                        converted += 900;
                        i++;
                    }
                    else{
                        converted+=100;
                    }
                }
                else{
                    converted+=100;
                }
            }
            else if(num.charAt(i) == 'D'){
                converted+=500;
            }
            else if(num.charAt(i) == 'M'){
                converted+=1000;
            }
        }
        return converted;
    }
    public static void main(String args []){
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for(int i = 0; i < cases; i++){
            String equation = input.next();
            int index = equation.indexOf("+");
            int sum = convertToInt(equation.substring(0, index)) + convertToInt(equation.substring(index+1, equation.length()-1));
            if(sum > 1000){
                System.out.println(equation + "CONCORDIA CUM VERITATE");
            }
            else{
                System.out.println(equation+convertToRoman(sum));
            }
        }
    }
}