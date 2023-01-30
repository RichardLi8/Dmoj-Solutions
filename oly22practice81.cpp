#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

const int MM = (int)2e5+1;
int n, m, p[MM], ans[MM];
vector <int> adj[MM];

int find(int x){
    if(p[x] != x) return p[x] = find(p[x]);
    return x;
}

void merge(int u, int v, int &ans){
    int x = find(u), y = find(v);
    if(x == y) return;
    p[y] = p[x];
    ans--;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin >> n >> m;
    for(int i = 0; i < m; i++){
        int u, v; cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    for(int i = n-1; i >= 0; i--){
        p[i+1] = i+1;
        ans[i] = ans[i+1]+1;
        for(int v: adj[i+1]){
            if(v < i+1) continue;
            merge(i+1, v, ans[i]);
        }
    }
    for(int i = 1; i <= n; i++){
        cout << ans[i] << "\n";
    }
    return 0;
}