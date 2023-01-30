#include <bits/stdc++.h>

using namespace std;

long k; vector <int> factors;

int getFactor(long n){
    for(long i = 2; i <= sqrt(n); i++){
        if(n % i == 0) return i;
    }
    return -1;
}

int main(){
    cin >> k;
    k++;
    long sum = 0;
    while(true){
        int val = getFactor(k);
        if(val == -1) break;
        factors.push_back(val-1);
        sum += val-1;
        k/=val;
    }
    if(k != 1) {
        factors.push_back(k);
        sum += k-1;
    }
    if(sum > 1e5){
        cout << "Sad Chris" << endl;
        return 0;
    }
    cout << sum << endl;
    for(int i = 1; i <= factors.size(); i++){
        for(int j = 0; j < factors [i-1]; j++){
            cout << i << " ";
        }
    }
    cout << endl;
    return 0;
}