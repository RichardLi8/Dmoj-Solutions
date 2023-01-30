#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
struct triple{
    ll st, ed, h;
};

bool cmp(triple x, triple y){
    return x.ed < y.ed;
}

triple animes [100000];
int n;
vector <pair<ll,ll>> dp;
set <pair<ll, ll>> s;

ll find(ll pos){
    ll l = 0, r = dp.size()-1;
    while(l <= r){
        ll mid = (l+r)/2;
        if(dp [mid].first > pos){
            r = mid-1;
        }
        else{
            l = mid+1;
        }
    }
    return r;
}

void update(int i){
    int cur = find(animes [i].ed);
    int pre = find(animes [i].st);
    dp [cur].second = max(dp [cur].second, dp [pre].second + animes [i].h);
    dp [cur].second = max(dp [cur-1].second, dp [cur].second);
}

int main(){
    ios_base::sync_with_stdio(false); 
    cin >> n;
    dp.push_back({0, 0});
    for(int i = 0; i < n; i++){
        ll r, l, h; cin >> r >> l >> h;
        animes [i] = {r, r+l, h};
        s.insert({r+l, 0});
    }
    sort(animes, animes + n, cmp);
    for(pair <ll,ll> p : s){
        dp.push_back(p);
    }
    s.clear();
    for(ll i = 0; i < n; i++){
        update(i);
    }
    cout << dp [dp.size()-1].second << endl;
    return 0;
}