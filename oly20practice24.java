import java.util.*;
/**
 *
 * @author richa
 */
public class AliceShoppingTrip {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int n = input.nextInt();
        Integer [] stores = new Integer [n];
        for(int i = 0; i < n; i++){
            stores [i] = input.nextInt();
        }
        Arrays.sort(stores, new myCmp());
        int count = 0;
        int dist = 0;
        if(stores[0] < t){
            dist += stores [0];
            count++;
        }
        else{
            dist += stores [0];
            System.out.println("0");
            return;
        }
        while(dist < t && count +1 < stores.length){
            if(Math.abs(stores [count] - stores [count-1]) + dist <= t){
                dist += Math.abs(stores [count] - stores [count-1]);
                count++;
            }
            else{
                break;
            }
        }
        System.out.println(count);
    }
    
}

class myCmp implements Comparator<Integer>{
	public int compare(Integer x, Integer y) {
		return Double.compare(Math.abs(x), Math.abs(y));
	}
}