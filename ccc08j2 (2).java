import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        ArrayList <Character> songs = new ArrayList();
        songs.add('A'); songs.add('B'); songs.add('C'); songs.add('D'); songs.add('E');
        while(true){
            int b = readInt(), n = readInt();
            if(b == 1){
                for(int i = 0; i < n; i++){
                    songs.add(songs.get(0));
                    songs.remove(0);	
                }
            }
            else if(b == 2){
                for(int i = 0; i < n; i++){
                    songs.add(0, songs.get(4));
                    songs.remove(5);	
                }
            }
            else if(b == 3){
                for(int i = 0; i < n; i++){
                    char temp = songs.get(0);
                    songs.set(0, songs.get(1));
                    songs.set(1, temp);
                }
            }
            else if(b == 4){
                for(char song : songs){
                        System.out.print(song + " ");
                }
                break;
            }
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(y == p.y) return -Integer.compare(x, p.x);
            return -Integer.compare(y, p.y);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) { 
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
}