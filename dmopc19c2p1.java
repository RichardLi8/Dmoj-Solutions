import java.util.*;
import java.text.*;
/**
 *
 * @author richa
 */
public class BoxAndWhiskers {
    
    public static double median(double nums []){
        Arrays.sort(nums);
        if(nums.length % 2 == 1){
            return(nums[nums.length/2]);
        }
        else{
            return (nums[nums.length/2] + nums[nums.length/2-1])/2;
        }
    }
    
    public static double Q1(double nums []){
        double first [] = new double [nums.length/2];
        for(int i = 0; i < nums.length/2; i++){
            first [i] = nums[i];
        }
        return median(first);
    }
    
    public static double Q2(double nums []){
        return median(nums);
    }
    
    public static double Q3(double nums []){
        double second [] = new double[nums.length/2];
        for(int i = nums.length-nums.length/2; i < nums.length; i++){
            second[i-nums.length+nums.length/2] = nums[i];
        }
        return median(second);
    }
    public static double max(double nums []){
        Arrays.sort(nums);
        return nums[nums.length-1];
    }
    
    public static double min(double nums []){
        Arrays.sort(nums);
        return nums[0];
    }
    
    public static boolean decimal(double nums){
        if((nums*2)%2 == 1){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0");
        int n = input.nextInt();
        double [] nums = new double [n];
        for(int i = 0; i < n; i++){
            nums [i] = input.nextDouble();
        }
        System.out.print(df.format(min(nums)) + " " + df.format(max(nums)) + " ");
        if(decimal(Q1(nums))){
            System.out.print(Q1(nums) + " ");
        }
        else{
            System.out.print(df.format(Q1(nums)) + " ");
        }
        if(decimal(Q2(nums))){
            System.out.print(Q2(nums) + " ");
        }
        else{
            System.out.print(df.format(Q2(nums)) + " ");
        }
        if(decimal(Q3(nums))){
            System.out.print(Q3(nums) + " ");
        }
        else{
            System.out.print(df.format(Q3(nums)) + " ");
        }
    } 
}