#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;


struct interval{
    int st, ed, v;
};

ll dp [(int)2e6+10];
int n, m, r;
interval intervals[(int)1e3];

bool cmp (const interval &x, const interval &y){
    return x.ed < y.ed;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin >> n >> m >> r;
    for(int i = 0; i < m; i++){
        interval &in = intervals[i];
        cin >> in.st >> in.ed >> in.v;
        in.st++;
    }
    sort(intervals, intervals+m, cmp);
    int idx = 0;
    ll ans = 0;
    for(int i = 1; i <= n; i++){
        for(; idx < m; idx++){
            if(i < intervals[idx].ed) break;
            int st = intervals[idx].st, ed = intervals[idx].ed, v = intervals[idx].v;
            ans = max(ans, dp[st-1]+v);
            dp[ed+r] = max(dp[ed+r], dp[st-1] + v);
        }
        dp[i] = max(dp[i], dp[i-1]);
    }
    cout << ans << "\n";
    return 0;
}