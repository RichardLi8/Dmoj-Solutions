#include <bits/stdc++.h>

using namespace std;

set <pair<int, int>> pairs;
vector <pair<int, int>> points;

int main(){
    int n; cin >> n;
    for(int i = 0; i < n; i++){
        int x, y; cin >> x >> y;
        points.push_back({x, y});
        pairs.insert(make_pair(x, y));
    }
    int ans = 0;
    for(int i = 0; i < n; i++){
        for(int j = i+1; j < n; j++){
            int x1 = points [i].first, y1 = points [i].second;
            int x2 = points [j].first, y2 = points [j].second;
            if(pairs.count(make_pair(x1, y2)) && pairs.count(make_pair(x2, y1))){
                ans = max(ans, abs(x1-x2) * abs(y1-y2));
            }
        }
    }
    cout << ans << endl;
    return 0;
}