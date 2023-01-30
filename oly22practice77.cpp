#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int psa [251][251], n, x, y, ans;

int main(){
    ios_base::sync_with_stdio(0);
    cin >> x >> y >> n;
    for(int i = 0; i < n; i++){
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        psa [x1][y1] += 1;
        psa [x2+1][y1] -= 1;
        psa [x1][y2+1] -= 1;
        psa [x2+1][y2+1] += 1;  
    }
    for(int i = 1; i <= x; i++){
        for(int j = 1; j <= y; j++){
            psa [i][j] += psa [i-1][j] + psa [i][j-1] - psa [i-1][j-1];
            if(psa[i][j]) ans++;
        }
    }
    cout << ans;
    return 0;
}