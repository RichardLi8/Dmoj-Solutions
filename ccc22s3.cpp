#include <bits/stdc++.h>
typedef long long ll;
using namespace std;
int n, m, a [1000001], pre [1000001];
ll k;

int main(){
    std::ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> n >> m >> k;
        a [1] = 1;
        ll ans = 1;
        if(n > k){
            cout << -1 << "\n";
            return 0;
        }
        for(int i = 2; i <= n; i++){
            int needed = min((ll)i, k-ans-(n-i));
            needed = min(m, needed);
            if(i-needed == 0){
                a [i] = i;
                ans += i;
            }
            else if(pre[a [i-needed]] <= i-needed){
                a [i] = a [i-needed];
                pre [a [i-needed]] = i;
                ans += needed;
            }
        }
        if(ans != k){
            cout << -1 << "\n";
            return 0;
        }
        for(int i = 1; i <= n; i++){
            cout << a [i] << " ";
        }
        cout << "\n";

    return 0;
}