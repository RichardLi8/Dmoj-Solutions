#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

int n, m, sizes[10], vols[10], bases[10];

int main(){
    ios_base::sync_with_stdio(0);
    cin >> n >> m;
    for(int i = 0; i < m; i++){
        cin >> sizes[i];
    }
    for(int i = 0; i < n; i++){
        cin >> vols[i] >> bases[i];
    }
    ll ans = 0;
    for(int i = 0; i < m; i++){
        int dp [sizes[i]+1]; memset(dp, 0, sizeof(dp));
        for(int j = 0; j < n; j++){
            int val = bases[j], cost = vols[j];
            for(int k = cost; k <= sizes[i]; k++){
                dp[k] = max(dp[k], dp[k-cost] + val);
            }
        }
        ans += dp[sizes[i]];
    }
    cout << ans << "\n";
    return 0;
}