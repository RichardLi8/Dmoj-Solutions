#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

int n, q, dist[(int)1e5+1], fwd[(int)1e5+1], bwd[(int)1e5+1];
vector <pii> adj[(int)1e5+1];

void update(int src, int p){
    int max1 = bwd[src], max2 = 0, node1 = p, node2 = -1;
    for(auto a : adj[src]){
        int v = a.first, d = a.second;
        if(v == p) continue;
        if(fwd[v]+d >= max1){
            max2 = max1;
            node2 = node1;
            max1 = fwd[v]+d;
            node1 = v;
        }
        else if(fwd[v]+d < max1 && fwd[v]+d > max2){
            max2 = fwd[v]+d;
            node2 = v;
        } 
    }
    //update each neighbour with a backward dist
    for(auto a : adj[src]){
        int v = a.first, d = a.second;
        if(v == p) continue;
        if(node1 == v){
            bwd[v] = max2+d;
        }
        else bwd[v] = max1+d;
    }
}


//find the max dist forward with dp
void dfs(int src, int p){
    int &ans = fwd[src];
    if(ans != 0) return;
    for(auto a : adj[src]){
        int v = a.first, d = a.second;
        if(v == p) continue;
        dfs(v, src);
        ans = max(ans, fwd[v] + d);
    }
}

//answer
void solve(int src, int p){
    dfs(src, p);
    update(src, p);
    dist[src] = max(fwd[src], bwd[src]);
    for(auto a : adj[src]){
        int v = a.first, d = a.second;
        if(v == p) continue;
        solve(v, src);
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin >> n >> q;
    for(int i = 1; i < n; i++){
        int u, v, d;
        cin >> u >> v >> d;
        adj[u].push_back({v, d});
        adj[v].push_back({u, d});
    }
    solve(1, 0);
    for(int i = 0; i < q; i++){
        int x; cin >> x;
        cout << dist[x] << endl;
    }
    return 0;
}