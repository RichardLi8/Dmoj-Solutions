#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

string encrypt(string s, int k){
    string n = "";
    for(int i = 0; i < s.size(); i++){
        n += (s[i]-'a'+k)%26+'a';
    }
    return n;
}

int main(){
    ios_base::sync_with_stdio(0);
    string str1, str2; cin >> str1 >> str2;
    for(int i = 0; i < 26; i++){
        if(encrypt(str1, i) == str2){
            cout << "Yes\n";
            return 0;
        }
    }
    cout << "No\n";
    return 0;
}