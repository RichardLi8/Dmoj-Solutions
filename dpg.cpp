#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;

int dp [100001];
bool vis [100001];
vector <int> adj [100001];
int n, m;

int dfs(int src){
    if(vis [src]) return dp [src];
    vis [src] = true;
    for(int v : adj [src]){
        dp [src] = max(dp [src], dfs(v) + 1);
    }
    return dp [src];
}

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> n >> m;
    for(int i = 0; i < m; i++){
        int x, y; cin >> x >> y;
        adj [x].push_back(y);
    }
    int ans = 0;
    for(int i = 1; i <= n; i++){
        ans = max(ans, dfs(i));
    }
    cout << ans;
    return 0;
}