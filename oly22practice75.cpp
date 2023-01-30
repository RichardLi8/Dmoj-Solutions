#include <bits/stdc++.h>

using namespace std;
typedef long long ll;


int overlap(string str1, string str2){
    int len = min(str1.size(), str2.size());
    ll hash1 = 0, hash2 = 0, p = 131;
    int mod = 1e9 + 7, ans = 0;
    for(int i = 0; i < len; i++){
        hash1  = (hash1 + p * str1[str1.size()-1-i])%mod;
        p = (p * 131)%mod;
        hash2 = (hash2 * 131 + str2[i]*131) % mod;
        if(hash1 == hash2) ans = i+1;
    }
    return ans;
}

int main(){
    ios_base::sync_with_stdio(0);
    string str1, str2; cin >> str1 >> str2;
    cout << max(overlap(str1, str2), overlap(str2, str1)) << "\n";
    return 0;
}