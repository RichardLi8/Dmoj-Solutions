#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

int n, m, srcx, srcy, dist[202][202], dr[] = {1, 1, 1, -1, -1, -1, 0, 0}, dc[] = {-1, 0, 1, -1, 0, 1, -1, 1};
char g[202][202];

int main(){
    ios_base::sync_with_stdio(0);
    cin >> m >> n >> srcy >> srcx;
    memset(dist, 0x3f3f, sizeof(dist));
    for(int i = n; i >= 1; i--){
        for(int j = 1; j <= m; j++){
            cin >> g[i][j];
        }
    }
    queue <pii> q;
    q.push({srcx, srcy}); dist [srcx][srcy] = 0;
    while(!q.empty()){
        int x = q.front().first, y = q.front().second; q.pop();
        for(int i = 0; i < 8; i++){
            int nx = x + dr[i], ny = y + dc [i];
            if(g[nx][ny] != '.') continue;
            if(dist[nx][ny] > dist[x][y]+1){
                dist[nx][ny] = dist[x][y]+1;
                q.push({nx, ny});
            }
        }
    }
    int ans = 0;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            if(g[i][j] == '.') ans = max(ans, dist[i][j]);
        }
    }
    cout << ans << "\n";
    return 0;
}