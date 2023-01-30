#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int n, ans;
bool dp[76];

int main(){
    ios_base::sync_with_stdio(0);
    cin >> n;
    dp [0] = 1;
    for(int i = 0; i < n; i++){
        int a; cin >> a;
        for(int j = 75; j >= a; j--){
            if(dp [j-a]) dp [j] = 1;
        }
    }
    for(int i = 0; i <= 75; i++){
        if(dp [i]) ans++;
    }
    cout << ans << "\n";
    return 0;
}