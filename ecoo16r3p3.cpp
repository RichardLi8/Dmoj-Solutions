#include <iostream>
#include <unordered_set>

using namespace std;

int dp [2005];

int main(){
    int n; cin >> n;
    unordered_set <string> dict;
    for(int i = 0; i < n; i++) {
        string s; cin >> s;
        dict.insert(s);
    }
    for(int q = 0; q < 10; q++){
        string s; cin >> s; int n = s.length(); s = " " + s;
        fill(dp, dp+n+1, 1e9); dp [0] = 0;
        for(int i = 1; i <= n; i++){
            string cur = "";
            for(int j = i; j <= n; j++){
                cur += s[j];
                if(dict.count(cur) == 1 && dp [i-1] != 1e9){
                    dp [j] = min(dp [j], dp [i-1] + 1);
                }
            }
        }
        cout << dp [n]-1 << endl;
    }
    return 0;
}