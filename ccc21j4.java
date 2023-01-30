import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        String n = next();
        Deque <Character> q = new LinkedList();
        int l = 0, s = 0;
        for(int i = 0; i < n.length(); i++){
            q.add(n.charAt(i));
            if(n.charAt(i) == 'L') l++;
            else if(n.charAt(i) == 'S') s++;
        }
        int ans = 0;
        Deque <Character> left = new LinkedList(), right = new LinkedList(), temp = new LinkedList();
        for(int i = 0; i < l; i++){
            temp.addLast(q.removeFirst());
        }
        while(!temp.isEmpty()){
            if(temp.peekFirst() == 'L') temp.removeFirst();
            else if(temp.peekFirst() == 'M'){
                while(!q.isEmpty()){
                    if(q.peekFirst() != 'L'){
                        left.addLast(q.removeFirst());
                    }
                    else{
                        q.removeFirst();
                        q.addFirst(temp.removeFirst());
                        ans++;
                        break;
                    }
                }
            }
            else if(temp.peekFirst() == 'S'){
                while(!q.isEmpty()){
                    if(q.peekLast() != 'L'){
                        right.addFirst(q.removeLast());
                    }
                    else{
                        q.removeLast();
                        q.addLast(temp.removeFirst());
                        ans++;
                        break;
                    }
                }
            }
        }
        left.addAll(q); q.clear(); q.addAll(left); q.addAll(right);
        while(!q.isEmpty()){
            if(q.peekLast() == 'S') q.removeLast();
            else if(q.peekFirst() == 'M') q.removeFirst();
            else{
                q.removeFirst();
                q.removeLast();
                ans++;
            }
        }
        System.out.println(ans);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
}