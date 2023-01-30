import java.util.Scanner;
/**
 *
 * @author richa
 */
public class Shahir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int houses = input.nextInt();
        int roads = input.nextInt();
        int start = input.nextInt();
        int des = input.nextInt();
        Graph Graph = new Graph(houses+1);
        for(int i = 0; i < roads; i++){
            int road1 = input.nextInt();
            int road2 = input.nextInt();
            Graph.addWeightEdge(road1, road2, 1);
            Graph.addWeightEdge(road2, road1, 1);
        }
        if(Graph.dijekstra(start, des) != Integer.MAX_VALUE){
            System.out.println("GO SHAHIR!");
        }
        else{
            System.out.println("NO SHAHIR!");
        }
    }
    
}
class Graph {
    int V;//The number of vertices
    int E;//The number of edges
    
    int [][] adjWeight;
    boolean [][] adjMatrix;
    
    public Graph(int v){
        V = v;
        adjWeight = new int [V][V];
        adjMatrix = new boolean [V][V];
        
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                adjWeight [i][j] = 0;
                adjMatrix [i][j] = false;
            }
        }
    }
    
    
    public void addWeightEdge(int v1, int v2, int w){
        if(v1 < V && v2 < V){
            adjWeight[v1][v2] = w;
        }
    }
    
    public int minIndex(int [] dist, boolean [] isVisited){
        int index = -1;
        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i < V; i++){
            if(!isVisited [i] && dist [i] <= smallest){
                smallest = dist[i];
                index = i;
            }
        }
        return index;
    }
    public int dijekstra(int src, int des){
        int[] dist = new int [V];
        boolean [] isVisited = new boolean [V];
        for(int i = 0; i < V; i++){
            dist [i] = Integer.MAX_VALUE;
            isVisited [i] = false;
        }
        
        dist[src] = 0;//source vertex
        
        for(int i = 0; i < V - 1; i++){
            int u = minIndex(dist, isVisited);
            isVisited[u] = true;
            
            for(int v = 0 ; v < V; v++){
                if(!isVisited[v] && dist[u] != Integer.MAX_VALUE && adjWeight[u][v] >0 && dist[v] > dist[u] + adjWeight[u][v]){
                    dist[v] = dist[u] + adjWeight[u][v];
                }
            }
        }
        return dist[des];
    }
}