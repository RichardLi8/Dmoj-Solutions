#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;

int n;
bool adj [1001][1001];
int p[10001];
vector <int> components [1001];

int find(int x){
    if(x != p[x]) p[x] = find(p[x]);
    return p[x];
}

void merge(int x, int y){
    if(find(x) == find(y)) return;
    int f = max(find(x), find(y)), s = min(find(x), find(y));
    p[f] = p [s];
    components [s].insert(components [s].end(), components [f].begin(), components [f].end());
    components [f].clear();

}

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> n;
    for(int i = 1; i <= n; i++) {
        p [i] = i;
        components [i].push_back(i);
    }
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            cin >> adj [i][j];
            if(adj [i][j]){
                merge(i, j);
            }
        }
    }
    for(int i = 1; i <= n; i++){
        sort(components [i].begin(), components [i].end());
        for(int v : components [i]){
            cout << v << " ";
        }
        if(components [i].size() != 0){
            cout << endl;
        }
    }
    return 0;
}