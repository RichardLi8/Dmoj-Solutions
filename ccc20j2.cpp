#include <iostream>

using namespace std;

int main(){
    int p, n, r;
    cin >> p >> n >> r;
    if(n > p) cout << 0;
    else{
        int tot = n;
        for(int i = 1; ; i++){
            n *= r;
            tot += n;
            if(tot > p){cout << i; return 0;}
        }
    }
    return 0;
}