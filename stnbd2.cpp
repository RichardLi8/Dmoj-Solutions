#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;

int n, m; vector <int> adj [100001]; bool st [100001]; bool ed [100001]; ll dp [100001]; int mod = 1e9+7; ll paths [100001];

void dfs(int src){
    dp [src] = 0;
    if(ed [src]) paths [src] = 1;
    for(int v : adj [src]){
        if(dp [v] == -1){
            dfs(v);
        }
        paths [src] += paths [v];
        paths [src] %= mod;
        dp [src] += paths [v] + dp [v];
        dp [src] %= mod;
    }
}

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> n >> m;
    memset(st, true, sizeof(st));
    memset(ed, true, sizeof(ed));
    memset(dp , -1, sizeof(dp));
    for(int i = 0; i < m; i++){
        int x, y; cin >> x >> y;
        adj [x].push_back(y);
        ed [x] = false;
        st [y] = false;
    }
    ll ans = 0;
    for(int i = 1; i <= n; i++){
        if(st [i]){
            dfs(i);
            ans += dp [i];
            ans %= mod;
        }
    }
    cout << ans << endl;
    return 0;
}