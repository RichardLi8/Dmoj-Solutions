import java.io.*;
import java.util.*;

public class HelloWorld {

    static int[] minlevels, train;

    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        train = new int[n + 1];
        minlevels = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            train[i] = readInt();
        }
        List<edge> routes[] = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            routes[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = readInt(), y = readInt(), w = readInt();
            routes[x].add(new edge(y, w));
            routes[y].add(new edge(x, w));
        }
        minlevel(routes);
        long ans = mintime(n);
        System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
    }

    static void minlevel(List<edge> paths[]) {
        PriorityQueue<edge> q = new PriorityQueue();
        q.add(new edge(1, 0));
        Arrays.fill(minlevels, Integer.MAX_VALUE);
        minlevels[1] = 0;
        while (!q.isEmpty()) {
            int u = q.peek().v, d = q.poll().w;
            if(d > minlevels [u]) continue;
            for (edge e : paths[u]) {
                int v = e.v, w = e.w;
                if (minlevels[v] > Math.max(minlevels[u], w)) {
                    minlevels[v] = Math.max(minlevels[u], w);
                    q.add(new edge(v, minlevels[v]));
                }
            }
        }
    }

    static long mintime(int n) {
        if (minlevels[n] == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        PriorityQueue<edge> visit = new PriorityQueue<>();
        visit.add(new edge(train[1], 1));
        for (int i = 2; i < train.length; i++) {
            if(train [i] < visit.peek().v) visit.add(new edge(train [i], minlevels[i]));
        }
        long time = 0;
        while(!visit.isEmpty()){
            edge cur = visit.poll();
            while(!visit.isEmpty() && (visit.peek().v > cur.v || visit.peek().w >= minlevels [n])) visit.poll();
            if(visit.isEmpty()) {
                long traintime = cur.v, levelup = (minlevels [n]-cur.w);
                time += traintime * levelup;
                break;
            }
            long traintime = cur.v, levelup = (visit.peek().w-cur.w);
            time += traintime * levelup;
        }
        return time;
    }

    static class edge implements Comparable<edge> {

        int v, w;

        public edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public int compareTo(edge x) {
            if (x.w == w) {
                return Integer.compare(v, x.v);
            }
            return Integer.compare(w, x.w);
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
}