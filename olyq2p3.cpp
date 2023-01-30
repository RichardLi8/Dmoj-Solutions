#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int, int> pii;

int n, k; ll dp [10][101][1<<10]; vector <int> comb; vector <int> kings;
          // row, kings, mask
int main(){
    cin >> n >> k;
    for(int mask = 0; mask < 1 << n; mask++){
        if((mask & mask << 1 ) == 0){
            comb.push_back(mask);
            kings.push_back(__builtin_popcount(mask));
            dp [0][kings[kings.size()-1]][comb.size()-1] = 1;
        }
    }
    for(int r = 1; r < n; r++){
        for(int i = 0; i < comb.size(); i++){
            for(int j = 0; j < comb.size(); j++){
                int mask1 = comb [i], mask2 = comb [j];
                int nmask = mask2 | mask2 << 1 | mask2 >> 1;
                if((mask1 & nmask) == 0){
                    for(int m = 0; m + kings [i] <= k; m++){
                        dp [r][m + kings [i]][i] += dp [r-1][m][j];
                    }
                }
            }
        }
    }
    ll ans = 0;
    for(int i = 0; i < comb.size(); i++){
        ans += dp [n-1][k][i];
    }
    cout << ans << endl;
}