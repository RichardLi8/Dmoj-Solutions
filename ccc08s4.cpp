#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

int n, a[4], nums[4];
char ops[3];
string operators = "+-/*";

int eval(int pre, int cur, char op){
    if(op == '+'){
        pre += cur;
    }
    else if(op == '-'){
        pre -= cur;
    }
    else if(op == '*'){
        pre *= cur;
    }
    else{
        if(cur != 0 && pre%cur == 0){
            pre /= cur;
        }
        else return -2e9;
    }
    return pre;
}

int left(){
    int ans = nums[0];
    for(int i = 0; i < 3; i++){
        ans = eval(ans, nums[i+1], ops[i]);
        if(ans == -2e9) return ans;
    }
    return ans;
}

int middle(){
    int left = eval(nums[0], nums[1], ops[0]);
    int right = eval(nums[2], nums[3], ops[2]);
    if(left == -2e9 || right == -2e9) return -2e9;
    return eval(left, right, ops[1]);
}

int main(){
    ios_base::sync_with_stdio(0);
    cin >> n;
    for(int i = 0; i < n; i++){
        int ans = 0;
        for(int j = 0; j < 4; j++) cin >> a[j];
        for(int a = 0; a < 4; a++){
            for(int b = 0; b < 4; b++){
                if(a == b) continue;
                for(int c = 0; c < 4; c++){
                    if(a == c || b == c) continue;
                    for(int d = 0; d < 4; d++){
                        if(a == d || b == d || c == d) continue;
                        nums[0] = ::a[a]; nums[1] = ::a[b]; nums[2] = ::a[c]; nums[3] = ::a[d];
                        for(int e = 0; e < 4; e++){
                            for(int f = 0; f < 4; f++){
                                for(int g = 0; g < 4; g++){
                                    ops[0] = operators[e]; ops[1] = operators[f]; ops[2] = operators[g];
                                    int val = left();
                                    if(val <= 24 && val > ans) ans = val;
                                    val = middle();
                                    if(val <= 24 && val > ans) ans = val;
                                }
                            }
                        }   
                    }
                }
            }
        }
        cout << ans << "\n";
    }
}