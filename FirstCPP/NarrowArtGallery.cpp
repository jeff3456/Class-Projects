/*
 * NarrowArtGallery.cpp
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

int N, K;
int dp[205][205][4];
int main(){
        while (1){
                scanf("%d%d", &N, &K);
                if (N == 0 && K == 0) break;
                REP(i, 0, N+1) REP(j, 0, K+1) REP(t,0,4) dp[i][j][t] = INF;
                dp[0][0][0] = 0;
                int sum = 0;
                REP(i, 1, N + 1){
                        int a, b;
                        scanf("%d%d", &a, &b);
                        sum += a + b;
                        REP(k, 0, K + 1){
                                REP(t, 0, 4){

                                        dp[i][k][0] = min(dp[i][k][0], dp[i - 1][k][t]);

                                        int cnt = ((t & 1) == 1) + ((t & 2) == 2);
                                        if (k + cnt > K) continue;
                                        int val = 0;
                                        if (t & 1) val += a;
                                        if (t & 2) val += b;

                                        REP(pt, 0, 4){
                                                int nt = t | pt;
                                                if (nt == 3) continue;
                                                dp[i][k + cnt][nt] = min(dp[i][k + cnt][nt], dp[i - 1][k][pt] + val);
                                        }
                                }
                        }
                }
                int ans = INF;
                REP(t, 0, 4) ans = min(ans, dp[N][K][t]);
                printf("%d\n", sum-ans);
        }
        return 0;
}

