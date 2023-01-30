import java.util.*;
/**
 *
 * @author richa
 */
public class LaughGraphs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String s = input.next();
        boolean usedc [] = new boolean [2001];
        boolean usedr [] = new boolean [2001];
        char [][] graph = new char [2001][2001];
        for(int i = 0; i < 2001; i++){
            for(int j = 0; j < 2001; j++){
                graph [i][j] = '.';
            }
        }
        int c = 1000, r = 1000;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'v'){
                c++;
                graph [c][r] = '\\';
                usedc [c] = true;
                usedr [r] = true;
                r++;
            }
            else if(s.charAt(i) == '^'){
                graph [c][r] = '/';
                usedc [c] = true;
                usedr [r] = true;
                r++;
                c--;
            }
            else{
                graph [c][r] = '_';
                usedc [c] = true;
                usedr [r] = true;
                r++;
            }
        }
        for(int i = 0; i < 2001; i++){
            if(usedc [i]){
                for(int j = 0; j < 2001; j++){
                    if(usedr [j]){
                        System.out.print(graph [i][j]);
                    }
                }
                System.out.println();
            }
        }
    }
    
}