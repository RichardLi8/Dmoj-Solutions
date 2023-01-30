#include <iostream>

using namespace std;

int nums [401] ;
int dp [401][401];

int main(){
    int n; cin >> n;
    int ans = 0;
    for(int i = 1; i <= n; i++) cin >> nums [i];

    for(int i = n; i > 0; i--){
        dp [i][i] = nums [i];
        ans = max(ans, nums [i]);
        for(int j = i; j <= n; j++){
            if(!dp [i][j]) continue;
            for(int k = j+1; k <= n; k++){
                for(int a = k; a <= n; a++){
                    if(j + 1 == k && dp [i][j] && dp [i][j] == dp [k][a]){
                        dp [i][a] = dp [i][j] + dp [k][a];
                    }
                    else if(dp [i][j] && dp [i][j] == dp [k][a] && dp [j+1][k-1]){
                        dp [i][a] = dp [i][j] + dp [j+1][k-1] + dp [k][a];
                    }
                    ans = max(ans, dp [i][a]);
                }
            }
        }
    }
    cout << ans;
    return 0;
}