#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int n, k, a[1000];
string s;

int main() {
    ios_base::sync_with_stdio(0); cin.tie(NULL);
    cin >> n >> k;
    for(int i = 0; i < n; i++){
        cin >> s;
        for(int j = 0; j < k; j++){
            if(s[j] == 'T'){
                a[i] |= 1<<j;
            }
        }
    }
    int m = (1<<k);
    int ans = 0;
    for(int v = 0; v < m; v++){
        int cur = 2e9;
        for(int j = 0; j < n; j++){
            cur = min(cur, k - __builtin_popcount(a[j] ^ v));
        }
        ans = max(ans, cur);
    }
    cout << ans << "\n";
    return 0;
}