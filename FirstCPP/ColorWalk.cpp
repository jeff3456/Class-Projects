/*
 * ColorWalk.cpp
 *
 *  Created on: Oct 4, 2014
 *      Author: jeff
 */




#include <iostream>
#include <cstdio>
#include <cmath>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>
#include <stack>
#include <queue>
#include <set>
#include <map>
#include <sstream>
#include <complex>
#include <ctime>
#include <cassert>

using namespace std;

typedef long long ll;
typedef vector<int> VI;
typedef pair<int, int> PII;

#define REP(i,s,t) for(int i=(s);i<(t);i++)
#define FILL(x,v) memset(x,v,sizeof(x))

const int INF = (int)1E9;
#define MAXN 15

int N;
int hit[MAXN][1 << MAXN];
int deg[MAXN][2];
#define MAXM (MAXN*MAXN*2)
int L, adj[MAXN], lid[MAXM], lc[MAXM], lnxt[MAXM];
bool v[MAXM][1 << MAXN];
void il(int a, int b, int c){
        lnxt[L] = adj[a];
        lid[L] = b;
        lc[L] = c;
        adj[a] = L++;
}

int main(){
        int T;
        cin >> T;
        while (T--){
                scanf("%d", &N);
                FILL(adj, -1);
                L = 0;
                FILL(deg, 0);
                REP(i, 0, N) REP(j, 0, N) {
                        int x; scanf("%d", &x);
                        if (x) {
                                il(j, i, 0);
                                deg[i][0] ++;
                        }
                }
                REP(i, 0, N) REP(j, 0, N){
                        int x; scanf("%d", &x);
                        if (x) {
                                il(j, i, 1);
                                deg[i][1] ++;
                        }
                }
                int ans = 0;
                REP(k, 1, N+1){
                        int mask = (1 << k) - 1;
                        FILL(hit, 0);
                        FILL(v, 0);
                        queue<PII> q;
                        REP(i, 0, N){
                                if (deg[i][0] == 0){
                                        REP(m, 0, 1 << (k - 1)){
                                                q.push( PII(i, (m << 1)) );
                                        }
                                }
                                if (deg[i][1] == 0){
                                        REP(m, 0, 1 << (k - 1)){
                                                q.push(PII(i, 1 + (m << 1)));
                                        }
                                }
                        }
                        bool ok = 0;
                        while (!q.empty()){
                                PII now = q.front(); q.pop();
                                int x = now.first, m = now.second;
                                if (x == 0) {
                                        ok = 1;
                                        break;
                                }
                                int t = adj[x];
                                while (t != -1){
                                        int y = lid[t], c = lc[t];
                                        int m2 = ((m << 1) & mask) + c;
                                        if (v[t][m2]){
                                                t = lnxt[t];
                                                continue;
                                        }
                                        v[t][m2] = 1;
                                        hit[y][m2] ++;
                                        if (hit[y][m2] == deg[y][c]){
                                                q.push(PII(y, m2));
                                        }
                                        t = lnxt[t];
                                }
                        }
                        if (!ok) {
                                ans = k;
                                break;
                        }
                }
                printf("%d\n", ans);

        }
        return 0;
}
