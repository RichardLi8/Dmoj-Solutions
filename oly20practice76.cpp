#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int n, f1[26], f2[26], ans, cur;
string s;

int main(){
    ios_base::sync_with_stdio(0);
    cin >> n >> s;
    for(int i = 0; i < n; i++){
        s[i]-='a';
        f1[s[i]]++;
    }
    for(int i = n-1; i >= 0; i--){
        f1[s[i]]--; f2[s[i]]++;
        if(f1[s[i]] == 0 && f2[s[i]] > 1) cur--;
        else if(f1[s[i]] > 0 && f2[s[i]] == 1) cur++;
        ans = max(ans, cur);
    }
    cout << ans << "\n";
    return 0;
}