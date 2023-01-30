#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;

int n, m, t, ans, sum; pair <int, int> a [100001];
priority_queue <int, vector <int>, greater<int>> pq;

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> n >> m >> t;
    for(int i = 0; i < n; i++) cin >> a [i].first >> a [i].second;
    sort(a, a + n);
    for(int i = 0; i < n; i++){
        if(m < a [i].first*2) break;
        pq.push(a [i].second);
        sum += a [i].second;
        while(pq.size() > (m-a [i].first*2)/t){
            sum -= pq.top(); pq.pop();
        }
        ans = max(ans, sum);
    }
    cout << ans << endl;
    return 0;
}