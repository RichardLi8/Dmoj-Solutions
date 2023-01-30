#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair <int,int> pii;

int t, n, nums [600];

int main() {
    ios::sync_with_stdio(0); cin.tie(NULL);
    cin >> t;
    for(int q = 0; q < t; q++){
        cin >> n;
        if(n&1 == 1){
            for(int i = 0; i < n; i++){
                cin >> nums [i];
            }
            sort(nums, nums+n);
            for(int i = 0; i < n; i++){
                if(i+1 != n) cout << nums [i] << " ";
                else cout << nums [i];
            }
            cout << endl;
        }
        else{
            bool flag = true;
            for(int i = 0; i < n; i++){
                cin >> nums [i];
                if(i >= 1){
                    if(nums [i] != nums [i-1]) flag = false;
                }
            }
            if(flag){
                cout << -1 << endl;
            }
            else{
                sort(nums, nums+n);
                for(int i = n-1; i >= n/2; i--){
                    if(i-n/2 != 0) cout << nums [i] << " " << nums [i-n/2] << " ";
                    else cout << nums [i] << " " << nums [i-n/2];
                }
                cout << endl;
            }
        }
    }
    return 0;
}