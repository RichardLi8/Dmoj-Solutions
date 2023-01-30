#include <bits/stdc++.h>

using namespace std;

long long memo [1<<21], n;
bool a [21][21], vis [1<<21];
const int mod = 1e9 + 7;

int dfs(int male, int mask){
    if(vis [mask]) return memo [mask];
    if(male == n) return 1;
    vis [mask] = true;
    long long &ret = memo [mask];
    for(int j = 0; j < n; j++){
        if((mask & (1 << j)) == 0 && a [male][j] == true){
            ret += dfs(male + 1, mask | 1 << j);
            ret %= mod;
        }
    }
    return ret %= mod;
}

int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a [i][j];
        }
    }
    cout << dfs(0, 0) << endl;
    return 0;
}