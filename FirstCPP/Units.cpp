/*
 * Units.cpp
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
#define MAXN 100005

int N;
char buf[1000];
map<string, int> id;
string mid[15];
int deg[15];
bool v[15];
vector<PII> adj[15], radj[15];
int fac[15];
bool OK;
void dfs(int x, int f){
        v[x] = 1;
        int sz = adj[x].size();
        fac[x] = f;
        REP(i, 0, sz){
                int y = adj[x][i].first;
                int m = adj[x][i].second;
                if(!v[y]) dfs(y, m*f);
        }
        sz = radj[x].size();
        REP(i, 0, sz){
                int y = radj[x][i].first;
                int m = radj[x][i].second;
                if (f % m) {
                        OK = 0;
                        return;
                }
                if (!v[y]) dfs(y, f / m);
        }
}
int main(){
        while (scanf("%d", &N) && N!=0){
                id.clear();
                REP(i, 0, N){
                        scanf("%s", buf);
                        id[buf] = i;
                        mid[i] = buf;
                        adj[i].clear();
                        radj[i].clear();
                }
                REP(i, 0, N - 1){
                        scanf("%s", buf);
                        int lid = id[buf];
                        int m;
                        scanf("%s%d%s", buf, &m, buf);
                        int rid = id[buf];
                        adj[lid].push_back(PII(rid, m));
                        radj[rid].push_back(PII(lid, m));
                        FILL(deg, 0);
                        deg[rid] ++;
                }
                REP(rt, 0, N){
                        OK = 1;
                        FILL(v, 0);
                        dfs(rt, 1);
                        if (OK) {
                                break;
                        }
                }
                PII ord[15];
                REP(i, 0, N){
                        ord[i] = PII(fac[i], i);
                }
                sort(ord, ord + N);
                printf("1%s", mid[ord[0].second].c_str());
                REP(i, 1, N){
                        printf(" = %d%s", ord[i].first, mid[ord[i].second].c_str());
                }
                puts("");
        }
        return 0;
}
