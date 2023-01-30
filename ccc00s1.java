import java.util.Scanner;
/**
 *
 * @author richa
 */
public class SlotMachines {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int quarters = input.nextInt();
        int machine1 = 35-input.nextInt();
        int machine2 = 100-input.nextInt(); 
        int machine3 = 10-input.nextInt();
        int count = 1;
        int plays = 0;
        while(quarters != 0){
            quarters--;
            if(count == 1){
                machine1--;
                if(machine1 == 0){
                    machine1 = 35;
                    quarters += 30;
                }
            }
            else if(count == 2){
                machine2--;
                if(machine2 == 0){
                    machine2 = 100;
                    quarters += 60;
                }
            }
            else if(count == 3){
                machine3--;
                if(machine3 == 0){
                    machine3 = 10;
                    quarters += 9;
                }
            }
            count++;
            plays++;
            if(count>3){
                count = 1;
            }
        }
        System.out.println("Martha plays " + plays + " times before going broke.");
    }
    
}