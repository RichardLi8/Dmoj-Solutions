import java.io.*;
import java.util.*;

/**
 *
 * @author richa
 */
public class Test {
    
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int ans = 0;
        n--;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int m = j + 1; m < n; m++){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}