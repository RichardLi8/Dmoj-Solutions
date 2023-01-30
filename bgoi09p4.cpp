#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;

int n, h [1000001], j [1000001], ans [1000001];
vector <int> stk;

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> h [i];
    }
    for(int i = 0; i < n; i++){
        cin >> j [i];
    }
    for(int i = n-1; i >= 0; i--){
        while(stk.size() > 0 && stk [stk.size()-1] <= h [i]){
            stk.erase(stk.begin()+stk.size()-1);
        }
        if(j [i] > stk.size()){
            ans [i] = -1;
        }
        else{
            ans [i] = stk [stk.size()-j[i]];
        }
        stk.push_back(h [i]);
    }
    for(int i = 0; i < n; i++){
        cout << ans [i] << " ";
    }
    cout << endl;
    return 0;
}