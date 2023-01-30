#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;

int dp [3][301][3][301];
int h1, w1, h2, w2;

int dfs(int h1, int w1, int h2, int w2){
    if(dp [h1][w1][h2][w2] != -1){
        return dp [h1][w1][h2][w2];
    }
    else if(dp [h2][w2][h1][w1] != -1){
        return dp [h2][w2][h1][w1];
    }
    int &ret = dp [h1][w1][h2][w2] = 0;
    if((h1 | w1 | h2 | w2) == 1) return ret;
    //option 2
    if(h1 == 2){
        ret |= dfs(h1-1, w1, h2, w2) == 0;
    }
    if(h2 == 2){
        ret |= dfs(h1, w1, h2-1, w2) == 0;
    }
    for(int i = 1; i <= 10 && i < w1; i++){
        ret |= dfs(h1, w1-i, h2, w2) == 0;
    }
    for(int i = 1; i <= 10 && i < w2; i++){
        ret |= dfs(h1, w1, h2, w2-i) == 0;
    }
    //option 1
    if(h1 == 2){
        ret |= dfs(h1-1, w1, h1-1, w1) == 0;
    }
    if(h2 == 2){
        ret |= dfs(h2-1, w2, h2-1, w2) == 0;
    }
    for(int i = 1; i < w2; i++){
        ret |= dfs(h2, i, h2, w2-i) == 0;
    }
    for(int i = 1; i < w1; i++){
        ret |= dfs(h1, w1-i, h1, i) == 0;
    }
    return ret; 
}

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> h1 >> w1 >> h2 >> w2;
    memset(dp, -1, sizeof(dp));
    cout << (dfs(h1, w1, h2, w2) == 1? "W" : "L") << endl;
    return 0;
}