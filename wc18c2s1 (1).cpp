#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pi;
typedef pair <ll, ll> pl;

int n, m, x, y, c, maxx = 1e9, minx = 0, maxy = 1e9, miny = 0;

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> x >> y >> n >> m >> c;
    for(int i = 0; i < n; i++){
        int v; cin >> v;
        if(v < x && minx < v) minx = v;
        else if(v > x && maxx > v) maxx = v;
    }
    for(int i = 0; i < m; i++){
        int h; cin >> h;
        if(h < y && miny < h) miny = h;
        else if(h > y && maxy > h) maxy = h;
    }
    //cout << maxx << " " << minx << " " << maxy << " " << miny << "\n";
    for(int i = 0; i < c; i++){
        int r, c; cin >> r >> c;
        if(minx < r && maxx > r && miny < c && maxy > c) cout << "Y" << "\n";
        else cout << "N" << "\n";
    }
    return 0;
}