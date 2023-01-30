import java.util.*;
/**
 *
 * @author richa
 */
public class MouseMove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxx = input.nextInt();
        int maxy = input.nextInt();
        int x = 0;
        int y = 0;
        while(true){
            int newx = input.nextInt();
            int newy = input.nextInt();
            if(newx == 0 && newy == 0) break;
            x+=newx;
            y+=newy;
            if(x > maxx) x = maxx;
            else if(x < 0) x = 0;
            if(y > maxy) y = maxy;
            else if(y < 0) y = 0;
            System.out.println(x + " " + y);
        }
    }
    
}