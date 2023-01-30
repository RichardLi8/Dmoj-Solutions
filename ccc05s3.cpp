#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

int n, r, c, v;
const vector<int> vec = vector<int>();

vector<vector<int>> tensor(vector<vector<int>> &a, vector<vector<int>> &b){
    vector<vector<int>> ret;
    int r1 = a.size(), c1 = a[0].size(), r2 = b.size(), c2 = b[0].size();
    for(int i = 0; i < r1*r2; i++) ret.push_back(vec);
    for(int i = 0; i < r1*r2; i+=r2){
        for(int j = 0; j < c1*c2; j+=c2){
            for(int k = 0; k < r2; k++){
                for(int l = 0; l < c2; l++){
                    ret[i+k].push_back(b[k][l] * a[i/r2][j/c2]);
                }
            }
        }
    }
    return ret;
}

vector<vector<int>> matrix(){
    cin >> r >> c;
    vector<vector<int>> a;
    for(int i = 0; i < r; i++){
        a.push_back(vec);
        for(int j = 0; j < c; j++){
            cin >> v;
            a[i].push_back(v);
        }
    }
    return a;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin >> n;
    vector<vector<int>> a = matrix(), b = matrix();
    a = tensor(a, b);
    for(int i = 0; i < n-2; i++){
        b = matrix();
        a = tensor(a, b);    
    }
    int maxVal = a[0][0], minVal = a[0][0], maxRow = -2e9, minRow = 2e9, maxCol = -2e9, minCol = 2e9;
    for(int i = 0; i < a.size(); i++){
        int col = 0;
        for(int j = 0; j < a[0].size(); j++){
            col += a[i][j];
            maxVal = max(maxVal, a[i][j]);
            minVal = min(minVal, a[i][j]);
        }
        maxCol = max(maxCol, col);
        minCol = min(minCol, col);
    }
    for(int j = 0; j < a[0].size(); j++){
        int row = 0;
        for(int i = 0; i < a.size(); i++){
            row += a[i][j];
        }
        maxRow = max(maxRow, row);
        minRow = min(minRow, row);
    }
    cout << maxVal << "\n" << minVal << "\n" << maxCol << "\n" << minCol << "\n" << maxRow << "\n" << minRow << "\n";
}