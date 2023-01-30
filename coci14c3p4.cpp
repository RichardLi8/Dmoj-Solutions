#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;

int n, psa [652][652], a [652][652]; pii ppl [500001];

int query(int x1, int y1, int x2, int y2){
    if(x1 == 652 || x2 == 652 || x2 == 0 || y2 == 0) return 0;
    return psa [x2][y2]-psa [x1-1][y2]-psa [x2][y1-1] + psa [x1-1][y1-1];
}

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> n;
    for(int i = 0; i < n; i++){
        int x, y; cin >> x >> y;
        ppl [i] = {x+1, y+1};
        a [x+1][y+1]++;
    }
    for(int i = 1; i <= 651; i++){
        for(int j = 1; j <= 651; j++){
            psa [i][j] = a [i][j] + psa [i-1][j] + psa [i][j-1] - psa [i-1][j-1];
        }
    }
    for(int i = 0; i < n; i++){
        int x = ppl [i].first, y = ppl [i].second;
        int smaller = query(1,1, x-1, y-1);
        int larger = query(x+1, y+1, 651, 651);
        cout << larger+1 << " " << n-smaller-(y==651?a[x][1]:0)-(x==651?a[1][y]:0) << endl;
    }
    return 0;
}