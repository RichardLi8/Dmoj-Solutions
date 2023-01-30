import java.util.Scanner;
/**
 *
 * @author richa
 */
public class ModInverse {

    public static boolean isCoPrime(int x, int m){
        for(int i = 2; i <= x && i <= m; i++){
            if(x % i == 0 && m % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int m = input.nextInt();
        if(!isCoPrime(x, m)){
            System.out.println("No such integer exists.");
        }
        else{
            boolean found = false;
            int count = 1;
            while(!found){
                if((x * count) % m == 1){
                    System.out.println(count);
                    found = true;
                }
                else{
                    count++;
                }
            }
        }
    }
}