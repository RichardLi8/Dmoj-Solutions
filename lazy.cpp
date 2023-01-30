#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

const int MM = (int)1e5+1;
int n, q;
ll a[MM+1], seg[4*MM], lazy1[4*MM], lazy2[4*MM];

void build(int l, int r, int pos){
    if(l == r){
        seg[pos] = a[l];
        return;
    }
    int mid = (l+r)/2;
    build(l, mid, 2*pos); build(mid+1, r, 2*pos+1);
    seg[pos] = min(seg[2*pos], seg[2*pos+1]);
}

void pushDown(int l, int r, int pos){
    if(lazy2[pos] != 0){
        lazy2[2*pos] = lazy2[2*pos+1] = lazy2[pos];
        lazy1[2*pos] = lazy1[2*pos+1] = 0;
        seg[2*pos] = lazy2[pos];
        seg[2*pos+1] = lazy2[pos];
        lazy2[pos] = 0;
    }
    if(lazy1[pos] != 0){
        lazy1[2*pos] += lazy1[pos];
        lazy1[2*pos+1] += lazy1[pos];
        seg[2*pos] += lazy1[pos];
        seg[2*pos+1] += lazy1[pos];
        lazy1[pos] = 0;
    }
}

void add(int l, int r, int ul, int ur, int val, int pos){
    if(l == ul && ur == r){
        seg[pos] += val;
        lazy1[pos] += val;
        return;
    }
    pushDown(l, r, pos);
    int mid = (l+r)/2;
    if(ur <= mid){
        add(l, mid, ul, ur, val, 2*pos);
    }
    else if(ul > mid){
        add(mid+1, r, ul, ur, val, 2*pos+1);
    }
    else{
        add(l, mid, ul, mid, val, 2*pos); add(mid+1, r, mid+1, ur, val, 2*pos+1);
    }
    seg[pos] = min(seg[2*pos], seg[2*pos+1]);
}

void assign(int l, int r, int ul, int ur, int val, int pos){
    if(l == ul && ur == r){
        seg[pos] = val;
        lazy2[pos] = val;
        lazy1[pos] = 0;
        return;
    }
    pushDown(l, r, pos);
    int mid = (l+r)/2;
    if(ur <= mid){
        assign(l, mid, ul, ur, val, 2*pos);
    }
    else if(ul > mid){
        assign(mid+1, r, ul, ur, val, 2*pos+1);
    }
    else{
        assign(l, mid, ul, mid, val, 2*pos); assign(mid+1, r, mid+1, ur, val, 2*pos+1);
    }
    seg[pos] = min(seg[2*pos], seg[2*pos+1]);
}

ll query(int l, int r, int ql, int qr, int pos){
    if(l == ql && qr == r){
        return seg[pos];
    }
    pushDown(l, r, pos);
    int mid = (l+r)/2;
    if(qr <= mid){
        return query(l, mid, ql, qr, 2*pos);
    }
    else if(ql > mid){
        return query(mid+1, r, ql, qr, 2*pos+1);
    }
    else{
        return min(query(l, mid, ql, mid, 2*pos), query(mid+1, r, mid+1, qr, 2*pos+1));
    }
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(NULL);
    cin >> n >> q;
    for(int i = 1; i <= n; i++) cin >> a[i];
    build(1, n, 1);
    while(q--){
        int c; cin >> c;
        if(c == 1){
            int l, r, v; cin >> l >> r >> v;
            add(1, n, l, r, v, 1);
        }
        else if(c == 2){
            int l, r, v; cin >> l >> r >> v;
            assign(1, n, l, r, v, 1);
        }
        else{
            int l, r; cin >> l >> r;
            cout << query(1, n, l, r, 1) << "\n";
        }
    }
    return 0;
}