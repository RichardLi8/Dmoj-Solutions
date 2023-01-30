import java.util.Scanner;
/**
 *
 * @author richa
 */
public class DarcySDebilitatingDemands {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for(int i = 0; i< cases; i++){
            int sum = input.nextInt();
            int A = input.nextInt();
            int B = input.nextInt();
            int C = input.nextInt();
            int first = 0;
            int second = 0;
            int third = 0;
            boolean possible = true;
            if(C < sum){
                third = C;
                sum -= C;
                if(B < sum){
                    second = B;
                    sum -= B;
                    if(A < sum){
                        System.out.println(-1);
                        possible = false;
                    }
                    else{
                        first = sum;
                    }
                }
                else{
                    second = sum;
                }
            }
            else{
                third = sum;
            }
            if(possible){
                System.out.println(first + " " + second + " " + third);
            }
        }
    }
}