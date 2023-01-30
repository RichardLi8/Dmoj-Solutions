#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;

int n, x, y, r, nums [10000002];

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> n >> x >> y >> r;
    for(int i = 0; i < r; i++){
        int a, b; cin >> a >> b;
        nums [a]++; nums [b+1]--;
    }
    ll ans = 0;
    for(int i = 1; i <= n; i++){
        nums [i] += nums [i-1];
        if(i >= x && i <= y){
            ans += nums [i];
        }
    }
    cout << ans << endl;
    return 0;
}