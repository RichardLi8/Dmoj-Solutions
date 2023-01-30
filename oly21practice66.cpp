#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;

bool vis [100001]; int freq [100001]; int n; vector <int> prime;

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> n;
    for(int i = 2; i <= n; i++){
        if(!vis [i]){
            ll p = (ll)i*i;
            if(p < n){
                for(int j = p; j <= n; j += i){
                    vis [j] = true;
                }
            }
        }
        if(!vis [i]) prime.push_back(i);
    }
    for(int i = n; i >= 2; i--){
        int v = i;
        for(int j = 0; j < prime.size(); j++){
            if(v == 1) break;
            while(v%prime [j] == 0){
                v/=prime [j];
                freq [prime [j]]++;
            }
        }
    }
    ll ans = 1;
    for(int i = 2; i <= n; i++){
        ans = (ans * (freq [i] + 1))%1000000007;
    }
    cout << ans;
    return 0;
}