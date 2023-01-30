#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int n, t, m, a [(int)1e5+2], ans;

int main(){
    ios_base::sync_with_stdio(0);
    cin >> n >> t >> m;
    for(int i = 0; i < m; i++){
        int w; cin >> w;
        a [w]++;
        t--;
    } 
    for(int i = 1; i <= n; i++){
        if(a[i] + t > 0) ans++;
    }
    cout << ans << "\n";
    return 0;
}