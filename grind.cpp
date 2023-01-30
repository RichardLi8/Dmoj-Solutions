#include <bits/stdc++.h>

using namespace std;

const int M = 1e7;
int n, tasks [M+1];

int main(){
    cin >> n;
    for(int i = 0, s, f; i < n; i++){
        cin >> s >> f;
        tasks [s] += 1;
        tasks [f] -=1;
    }
    int ans = 0;
    for(int i = 1; i <= M; i++){
        tasks [i] += tasks [i-1];
        ans = max(ans, tasks [i]);
    }
    cout << ans;
    return 0;
}