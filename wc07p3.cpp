#include <bits/stdc++.h>

using namespace std;

int t, n, a [15][15], memo [15][1<<15];
const int mod = 13371337;

int dfs(int src, int mask){
    if(memo [src][mask] != -1) return memo [src][mask];
    if(src == n-1) return 1;
    int &ret = memo [src][mask] = 0;
    for(int i = 1; i < n; i++){
        if(a [src][i] && (mask & (1<<i)) == 0){
            ret += dfs(i, mask | (1 << i));
            ret%=mod;
        }
    }
    return ret;
}

int main(){
    cin >> t;
    for(int q = 0; q < t; q++){
        cin >> n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cin >> a[i][j];
            }
        }
        memset(memo, -1, sizeof(memo));
        cout << dfs(0, 1) <<endl;
    }
    return 0;
}