#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;

int n, q; ll psa [100001];

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> n >> q;
    for(int i = 1; i <= n; i++){
        int x; cin >> x;
        if(x <= 0) continue;
        psa [i] = x;
    }
    sort(psa+1, psa+n+1, greater<ll>());
    for(int i = 1; i <= n; i++){
        psa [i] += psa [i-1];
    }
    for(int i = 0; i < q; i++){
        int k; cin >> k;
        cout << psa [k] << endl;
    }
    return 0;
}