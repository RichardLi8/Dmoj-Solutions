#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;
typedef pair <int, string> pis;

int n; pis a [100001];
bool cmp(pis x, pis y){
    if(x.first == y.first) return x.second > y.second;
    return x.first > x.first;
}

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> n;
    for(int i = 0; i < n; i++){
        string s; int v; cin >> s >> v;
        a [i] = {v, s};
    }
    sort(a, a + n);
    cout << a [n/2].second << endl;
    return 0;
}