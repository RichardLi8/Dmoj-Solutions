#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pi;
typedef pair <ll, ll> pl;

int n, m, p [(int)1e5+1];

bool query(int dist){
    int cnt = 1, pre = p [0];
    for(int i = 1; i < n; i++){
        if(p[i]-pre < dist) continue;
        cnt++;
        pre = p[i];
    }
    return cnt >= m;
}

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> n >> m;
    for(int i = 0; i < n; i++) cin >> p [i];
    sort(p, p+n);
    int l = 0, r = 1e9;
    while(l <= r){
        int mid = (l+r)/2;
        if(query(mid)){
            l = mid+1;
        }
        else r = mid-1;
    }
    cout << r << "\n";
}