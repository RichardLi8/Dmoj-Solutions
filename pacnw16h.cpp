#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <ll,ll> pii;

bool cmp(pii x, pii y){
    return x.second < y.second;
}

pii intervals [200001]; ll dp [200001];
ll n, k;

int main() {
    cin >> n >> k;
    for(int i = 1; i <= k; i++){
        cin >> intervals [i].first >> intervals [i].second;
    }
    sort(intervals, intervals+k+1, cmp);
    for(int i = 1; i <= k; i++){
        int l = 0, r = i-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(intervals [mid].second > intervals [i].first){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        dp [i] = max(dp [i-1], dp [r] + intervals [i].second-intervals [i].first+1);
    }
    cout << n-dp [k] << endl;
    return 0;
}