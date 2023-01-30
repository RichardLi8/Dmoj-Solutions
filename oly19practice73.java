import java.util.*;
/**
 *
 * @author richa
 */
public class Test {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long money = input.nextLong();
        Items gifts [] = new Items [n];
        for(int i = 0; i < n; i++){
            gifts [i] = new Items(input.nextLong(), input.nextLong());
        }
        Arrays.sort(gifts, new cmp());
        long sum = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(sum + gifts [i].cost + gifts [i].shipping > money){
                if(sum + gifts[i].cost/2 + gifts[i].shipping > money){
                    break;
                }
                else{
                    sum += gifts[i].cost/2 + gifts[i].shipping;
                    count++;
                }
            }
            else{
                sum += gifts[i].cost + gifts[i].shipping;
                count++;
            }
        }
        System.out.println(count);
    } 
}
class cmp implements Comparator <Items>{
    public int compare(Items x, Items y){
        long cost1 = x.cost+x.shipping;
        long cost2 = y.cost+y.shipping;
        if(cost1 != cost2){
            return Long.compare(cost1, cost2);
        }
        else{
            return Long.compare(x.cost, y.cost);
        }
    }
}
class Items{
    long cost;
    long shipping;
    public Items(long c, long s){
        cost = c;
        shipping = s;
    }
}