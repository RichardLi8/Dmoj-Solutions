import java.util.*;
/**
 *
 * @author richa
 */
public class UpAndDown {

    public static int steps(int f, int b, int n){
        int dir = 1;
        int pos = 0;
        int steps = 0;
        while(true){
            if(dir%2 == 1 && steps + f <= n){
                steps += f;
                pos += f;
            }
            else if(dir%2 == 0 && steps + b <= n){
                steps += b;
                pos -= b;
            }
            else{
                if(dir%2 == 1){
                    return pos += n-steps;
                }
                else{
                    return pos -= n-steps;
                }
            }
            dir++;
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int d = input.nextInt();
        int n = input.nextInt();
        int nikky = steps(a,b,n);
        int byron = steps(c,d,n);
        if(nikky > byron) System.out.println("Nikky");
        else if(byron > nikky) System.out.println("Byron");
        else System.out.println("Tied");
    } 
}