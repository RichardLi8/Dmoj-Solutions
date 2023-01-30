#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;

vector <int> adj [1000001]; bool sawmill [1000001]; double prob [1000001];

int n, m;

void update(int src){
    int connections = adj [src].size();
    for(int v : adj [src]){
        prob [v] += prob [src]/connections;
    }
}

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL);
    cin >> n >> m;
    memset(sawmill, true, sizeof(sawmill));
    for(int i = 0; i < m; i++){
        int x, y; cin >> x >> y;
        adj [x].push_back(y);
        sawmill [x] = false;
    }
    prob [1] = 1;
    for(int i = 1; i <= n; i++){
        update(i);
    }
    for(int i = 1; i <= n; i++){
        if(sawmill [i]){
            printf("%.9f\n", prob [i]);
        }
    }
    return 0;
}