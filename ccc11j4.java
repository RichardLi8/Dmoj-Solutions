import java.util.Scanner;
/**
 *
 * @author richa
 */
public class BoringBusiness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int grid [][] = new int [402][201];
        grid [201][1] = 1;
        grid [201][2] = 1;
        grid [201][3] = 1;
        grid [202][3] = 1;
        grid [203][3] = 1;
        grid [204][3] = 1;
        grid [204][4] = 1;
        grid [204][5] = 1;
        grid [205][5] = 1;
        grid [206][5] = 1;
        grid [206][4] = 1;
        grid [206][3] = 1;
        grid [207][3] = 1;
        grid [208][3] = 1;
        grid [208][4] = 1;
        grid [208][5] = 1;
        grid [208][6] = 1;
        grid [208][7] = 1;
        grid [207][7] = 1;
        grid [206][7] = 1;
        grid [205][7] = 1;
        grid [204][7] = 1;
        grid [203][7] = 1;
        grid [202][7] = 1;
        grid [201][7] = 1;
        grid [200][7] = 1;
        grid [200][6] = 1;
        grid [200][5] = 1;
        int xPos = 200;
        int yPos = 5;
        String direction = "";
        while(!direction.equals("q")){
            direction = input.next();
            if(!direction.equals("q")){
                int distance = input.nextInt();
                if(direction.equals("u")){
                    for(int i = 0; i < distance; i++){
                        yPos--;
                        if(grid[xPos][yPos] == 1){
                            direction = "q";
                        }
                        grid[xPos][yPos] = 1;
                    }
                }
                else if(direction.equals("d")){
                    for(int i = 0; i < distance; i++){
                        yPos++;
                        if(grid[xPos][yPos] == 1){
                            direction = "q";
                        }
                        grid[xPos][yPos] = 1;
                    }
                }
                else if(direction.equals("l")){
                    for(int i = 0; i < distance; i++){
                        xPos--;
                        if(grid[xPos][yPos] == 1){
                            direction = "q";
                        }
                        grid[xPos][yPos] = 1;
                    }
                }
                else if(direction.equals("r")){
                    for(int i = 0; i < distance; i++){
                        xPos++;
                        if(grid[xPos][yPos] == 1){
                            direction = "q";
                        }
                        grid[xPos][yPos] = 1;
                    }
                }
                
                if(!direction.equals("q")){
                    System.out.println(xPos-201 + " -" + yPos + " safe");
                }
                else{
                    System.out.println(xPos-201 + " -" + yPos + " DANGER");
                }
            }
        }
    }
}