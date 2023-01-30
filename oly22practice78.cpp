#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

struct interval{
    int s, e, c;
};

bool cmp(const interval &x, const interval &y){
    return x.e < y.e;
}

const int MM = (int)5e4+1;
int n, ans;
interval intervals[MM];

int seg[4*MM];
bool lazy[4*MM];

void pushDown(int l, int r, int pos){
    if(lazy[pos] == 0) return;
    lazy[2*pos]=1; lazy[2*pos+1]=1;
    int mid = (l+r)/2;
    seg[2*pos]=(mid-l+1); seg[2*pos+1]=(r-mid);
    lazy[pos]=0;
}

void update(int l, int r, int ul, int ur, int pos){
    if(l == ul && ur == r){
        seg[pos] = (r-l+1);
        lazy[pos] = 1;
        return;
    }
    int mid = (l+r)/2;
    pushDown(l, r, pos);
    if(ur <= mid){
        update(l, mid, ul, ur, 2*pos);
    }
    else if(ul > mid){
        update(mid+1, r, ul, ur, 2*pos+1);
    }
    else{
        update(l, mid, ul, mid, 2*pos); update(mid+1, r, mid+1, ur, 2*pos+1);
    }
    seg[pos] = seg[2*pos]+seg[2*pos+1];
}

int query(int l, int r, int ql, int qr, int pos){
    if(l == ql && qr == r){
        return seg[pos];
    }
    int mid = (l+r)/2;
    pushDown(l, r, pos);
    if(qr <= mid){
        return query(l, mid, ql, qr, 2*pos);
    }
    else if(ql > mid){
        return query(mid+1, r, ql, qr, 2*pos+1);
    }
    else return query(l, mid, ql, mid, 2*pos) + query(mid+1, r, mid+1, qr, 2*pos+1);
}

int find(int s, int e, int cnt){
    int l = 0, r = e;
    while(l<=r){
        int mid = (l+r)/2;
        int val = query(0, MM, mid, e, 1);
        if(e-mid+1 == cnt + val) return mid;
        else if(e-mid+1 < cnt+val) r = mid-1;
        else l = mid+1;
    }
    return 0;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin >> n;
    for(int i = 0; i < n; i++){
        interval &in = intervals[i];
        cin >> in.s >> in.e >> in.c;
    }
    sort(intervals, intervals+n, cmp);
    for(int i = 0; i < n; i++){
        int s = intervals[i].s, e = intervals[i].e, need = intervals[i].c;
        int used = query(0, MM, s, e, 1);
        if(need <= used) continue;
        int add = need-used;
        int idx = find(s, e, add);
        update(0, MM, idx, e, 1);
        ans += add;
    }
    cout << ans << "\n";
    return 0;
}