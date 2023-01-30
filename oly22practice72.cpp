#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int main(){
    ios_base::sync_with_stdio(0);
    //multiple of 3 if digits add to 3
    int n; cin >> n;
    string s;
    for(int i = 0; i < n; i++){
        cin >> s;
        int sum = 0;
        for(int j = 0; j < s.length(); j++){
            sum += s[j]-'0';
        }
        if(sum%3==0) cout << "yes\n";
        else cout << "no\n";
    }
    return 0;
}