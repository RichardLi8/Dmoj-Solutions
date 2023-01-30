#include <bits/stdc++.h>

using namespace std;

const int M = 2e5+1;
int n, m, k, best [M], prof [M];

int main(){
    cin >> n >> m >> k;
    memset(best, -1, sizeof(best));
    memset(prof, -1, sizeof(prof));
    for(int i = 0; i < k; i++){
        int a, b, c;
        cin >> a >> b >> c;
        if(best [b] < c){
            best [b] = c;
            prof [b] = a;
        }
    }
    for(int i = 1; i <= n; i++){
        cout << prof [i] << " ";
    }
    cout <<endl;
    return 0;
}