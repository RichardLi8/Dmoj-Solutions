#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

int n;
int dp [31][31][31][31];

int solve(int a, int b, int c, int d){
    if(dp[a][b][c][d] != 0) return dp[a][b][c][d];
    int &ret = dp[a][b][c][d]; ret = -1;
    if(a >= 2 && b && d >= 2){
        if(solve(a-2, b-1, c, d-2) == -1) ret = 1;
    }
    if(a && b && c && d){
        if(solve(a-1, b-1, c-1, d-1) == -1) ret = 1;
    }
    if(c >=2 && d){
        if(solve(a, b, c-2, d-1) == -1) ret = 1;
    }
    if(b >= 3){
        if(solve(a, b-3, c, d) == -1) ret = 1;
    }
    if(a && d){
        if(solve(a-1, b, c, d-1) == -1) ret = 1;
    }
    return ret;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin >> n;
    for(int i = 0; i < n; i++){
        int a, b, c, d;
        memset(dp, 0, sizeof(dp));
        cin >> a >> b >> c >> d;
        int ans = solve(a, b, c, d);
        if(ans == 1){
            cout << "Patrick\n";
        }
        else{
            cout << "Roland\n";
        }
    }
}