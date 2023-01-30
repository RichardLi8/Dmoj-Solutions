#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;

const int MM = 1e6;
int n, q, a [5001], freq [MM*2+1]; ll psa [5001][5001];

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> n >> q;
    for(int i = 1; i <= n; i++){
        cin >> a [i];
    }
    for(int i = 1; i <= n; i++){
        for(int j = i+1; j <= n; j++){
            int v = -a [i] - a[j] + MM;
            if(v >= 0 && v <= 2*MM){
                psa [i][j] += freq [v];
            }
            freq [a[j]+MM]++;
        }
        for(int k = i+1; k <= n; k++){
            freq [a[k]+MM]--;
        }
    }
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            psa [i][j] += psa [i][j-1] + psa [i-1][j] - psa [i-1][j-1];
        }
    }
    for(int i = 0; i < q; i++){
        int l, r; cin >> l >> r; l--;
        cout << psa [r][r] - psa [l][r] - psa [r][l] + psa [l][l] << endl;
    }
    return 0;
}