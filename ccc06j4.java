import java.util.*;

/**
 *
 * @author richa
 */
public class Test {
    static boolean connections[][] = new boolean [8][8];
    static boolean connected [] = new boolean [8];
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(), b = input.nextInt();
        addEdge(1, 7);
        addEdge(1, 4);
        addEdge(2, 1);
        addEdge(3, 4);
        addEdge(3, 5);
        while(a != 0 && b != 0){
            addEdge(a, b);
            a = input.nextInt();
            b = input.nextInt();
        }
        for(int i = 1; i < 8; i++){
            if(cycle(i)){
                System.out.println("Cannot complete these tasks. Going to bed.");
                return;
            }
        }
        List <Integer> ans = new LinkedList<>();
        for(int i = 7; i > 0; i--){
            for(int j = 7; j > 0; j--){
                if(connections [i][j]){
                    if(ans.contains(i)){
                        if(ans.contains(j)){
                            if(indexOf(i, ans) > indexOf(j, ans)){
                                ans.remove((Integer)j);
                                ans.add(indexOf(i, ans)+1, j);
                            }
                        }
                        else{
                            insertAfter(ans, j, indexOf(i, ans));
                        }
                    }
                    else{
                        if(ans.contains(j)){
                            insertBefore(ans, i, indexOf(j, ans));
                        }
                        else {
                            insert(ans, i);
                            insertAfter(ans, j, indexOf(i, ans));
                        }
                    }
                }
            }
            if(!ans.contains(i)) insert(ans, i);
        }
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
    }
    
    public static void insert(List <Integer> ans, int src){
        for(int i = 0; i < ans.size(); i++){
            if(ans.get(i) > src){
                ans.add(i, src);
                return;
            }
        }
        ans.add(src);
    }
    
    public static void insertAfter(List <Integer> ans, int src, int index){
        for(int i = index+1; i < ans.size(); i++){
            if(ans.get(i) > src){
                ans.add(i, src);
                return;
            }
        }
        ans.add(src);
    }
    
    public static void insertBefore(List <Integer> ans, int src, int index){
        for(int i = 0; i <= index; i++){
            if(ans.get(i) > src || i + 1 == index){
                ans.add(i, src);
                return;
            }
        }
    }
    
    public static int indexOf(int n, List <Integer> ans){
        for(int i = 0; i < 7; i++){
            if(ans.get(i) == n) return i;
        }
        return -1;
    }
    
    public static void addEdge(int src, int end){
        connections [src][end] = true;
        connected [end] = true;
    }
    
    public static boolean cycle(int src){
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(src);
        while(!myQueue.isEmpty()){
            int u = myQueue.poll();
            for(int i = 1; i < 8; i++){
                if(connections [u][i]){
                    if(i == src) return true;
                    myQueue.add(i);
                }
            }
        }
        return false;
    }
}