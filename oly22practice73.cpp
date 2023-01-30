#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int main(){
    ios_base::sync_with_stdio(0);
    int n; cin >> n;
    string s; cin >> s;
    //find longest moo substr
    int l = 0, r = 0, size = 0, len = s.length();
    for(int i = 0; i < len-2; i++){
        int cur = 0;
        for(int j = i; j < len-2; j++){
            if(s[j] == 'm' && s[j+1] == 'o' && s[j+2] == 'o'){
                j+=2;
                cur++;
            }
            else break;
        }
        if(cur > size){
            size = cur;
            l = i-1; r = i+cur*3;
        }
    }
    if(l > 1){
        cout << "no\n";
        return 0;
    }
    else if(l == 1 && !(s[0] == 'o' && s[1] == 'o')){
        cout << "no\n";
        return 0;
    }
    else if(l == 0 && s[0] != 'o'){
        cout << "no\n";
        return 0;
    }
    else if(l != -1){
        size++;
    }
    if(r < len-2){
        cout << "no\n";
        return 0;
    }
    else if(r == len-1 && s [len-1] != 'm'){
        cout << "no\n";
        return 0;
    }
    else if(r == len-2 && !(s[len-2] == 'm' && s[len-1] == 'o')){
        cout << "no\n";
        return 0;
    }
    else if(r != len){
        size++;
    }
    if(size <= n){
        cout << "yes\n";
    }
    else cout << "no\n";
    return 0;
}