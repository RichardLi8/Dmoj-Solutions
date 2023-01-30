#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;

int n, a [1000002];

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> n;
    for(int i = 0; i < n; i++){
        int x, y;
        cin >> x >> y;
        a [x]++; a [y]--;
    }
    int ans = 0;
    for(int i = 1; i <= 1000000; i++){
        a [i] += a [i-1];
        ans = max(ans, a [i]);
    }
    cout << ans;
    return 0;
}