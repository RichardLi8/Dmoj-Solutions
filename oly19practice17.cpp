#include <iostream>

using namespace std;
const int MM = 1e5;
int n, nums [MM+1], dp [MM+2];
int main(){
    cin >> n;
    for(int i = 0, x; i < n; i++){
        cin >> x;
        nums [x] += x;
    }
    dp [1] = nums [1];
    for(int i = 2; i <= MM; i++){
        dp [i] = max(dp [i-1], dp [i-2] + nums [i]);
    }
    cout << dp [MM] << endl;
    return 0;
}