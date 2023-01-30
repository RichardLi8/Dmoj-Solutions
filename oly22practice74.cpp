#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

string s;
int k, ans;

int main(){
    ios_base::sync_with_stdio(0);
    cin >> s >> k;
    for(int r = 0, l = 0; r < s.size(); r++){
        if(s[r] == '0'){
            k--;
            while(k < 0){
                if(s[l] == '0'){
                    k++;
                }
                l++;
            }
        }
        ans = max(ans, r-l+1);
    }
    cout << ans << "\n";
    return 0;
}