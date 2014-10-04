/*
 * HumanCannonball.cpp
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
typedef pair<int, double> PID;

#define REP(i,s,t) for(int i=(s);i<(t);i++)
#define FILL(x,v) memset(x,v,sizeof(x))

const int INF = (int)1E9;
#define MAXN 105

int N;
double sx, sy, ex, ey;
double x[MAXN], y[MAXN];
vector<PID> adj[MAXN];
double dist(int i, int j){
        return sqrt((x[i] - x[j])*(x[i] - x[j]) + (y[i] - y[j])*(y[i] - y[j]));
}
struct dij{
        int id;
        double t;
        dij(){}
        dij(int _id, double _t){
                id = _id;
                t = _t;
        }
        bool operator < (const dij &ano) const{
                return t > ano.t;
        }
};
double dst[MAXN];
double dijkstra(){
        REP(i, 0, N + 2) dst[i] = 1E20;
        dst[0] = 0;
        priority_queue<dij> pq;
        pq.push(dij(0, 0));
        while (!pq.empty()){
                dij now = pq.top(); pq.pop();
                if (now.t > dst[now.id]) continue;
                if (now.id == N + 1) return now.t;

                int x = now.id;
                int sz = adj[x].size();
                REP(i, 0, sz){
                        int y = adj[x][i].first;
                        double d = adj[x][i].second;
                        if (dst[x] + d < dst[y]){
                                dst[y] = dst[x] + d;
                                pq.push(dij(y, dst[y]));
                        }
                }
        }
        return -1;
}
int main(){
        cin >> sx >> sy >> ex >> ey;
        cin >> N;
        REP(i, 1, N+1){
                scanf("%lf%lf", x + i, y + i);
        }
        x[0] = sx; y[0] = sy;
        x[N + 1] = ex; y[N + 1] = ey;
        REP(i, 1, N + 2){
                double d = dist(0, i);
                double t = d / 5;
                adj[0].push_back(PID(i, t));
        }
        int T = N + 1;
        REP(i, 1, N + 1){
                REP(j, 1, N + 2){
                        if (i == j) continue;
                        double d = dist(i, j);
                        double t = d / 5;
                        t = min(t, 2 + fabs(d - 50) / 5);
                        adj[i].push_back(PID(j, t));
                }
        }
        double ans = dijkstra();
        printf("%.10f\n", ans);
        return 0;
}
