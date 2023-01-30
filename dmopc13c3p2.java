import java.util.*;
/**
 *
 * @author richa
 */
public class PhoneMircowave {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String date = input.next();
        int year = Integer.parseInt(date.split("/")[0]);
        int month = Integer.parseInt(date.split("/")[1]);
        int day = Integer.parseInt(date.split("/")[2]);
        String time = input.next();
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        int second = Integer.parseInt(time.split(":")[2]);
        int months [] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        while(n > 0){
            hour--;
            n--;
            if(hour < 0){
                hour = 23;
                day--;
            }
            if(day == 0){
                if(month == 1){
                    month = 12;
                    year--;
                    day = months[month-1];
                }
                else if(month == 3 && year%4 == 0){
                    day = 29;
                    month = 2;
                }
                else{
                    month--;
                    day =months[month-1];
                }
            }
        }
        String finalDate = "";
        finalDate += year+"/";
        if(month < 10){
            finalDate += "0"+month+"/";
        }
        else{
            finalDate += month+"/";
        }
        if(day < 10){
            finalDate += "0"+day+" ";
        }
        else{
            finalDate += day + " ";
        }
        if(hour < 10){
            finalDate += "0"+hour+":";
        }
        else{
            finalDate += hour+":";
        }
        if(minute < 10){
            finalDate += "0"+minute+":";
        }
        else{
            finalDate += minute+":";
        }
        if(second < 10){
            finalDate += "0"+second;
        }
        else{
            finalDate += second;
        }
        System.out.println(finalDate);
        
    }
    
}