import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int start = input.nextInt();
        int end = input.nextInt();
        int RSA = 0;
        for(int i = start; i <= end; i++){
            int count = 0;
            for(int j = 1; j <= i; j++){
                if(i%j == 0) count++;
            }
            if(count == 4) RSA++;
        }
        System.out.println("The number of RSA numbers between " + start + " and " + end + " is " + RSA);
    }
}