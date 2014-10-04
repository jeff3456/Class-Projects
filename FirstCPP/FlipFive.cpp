/*
 * FlipFive.cpp
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

char gd[4][4];
bool bd[4][4], obd[4][4];
int dir[5][2] = { 0, 0, 1, 0, -1, 0, 0, 1, 0, -1 };
int main(){
        int T;
        cin >> T;
        while (T--){
                REP(i, 0, 3){
                        scanf("%s", gd[i]);
                        REP(j, 0, 3){
                                obd[i][j] = gd[i][j] == '*';
                        }
                }
                int ans = 100;
                REP(m, 0, 1 << 9){
                        FILL(bd, 0);
                        int cnt = 0;
                        REP(i, 0, 9){
                                if ((1 << i)&m){
                                        cnt++;
                                        int x = i / 3, y = i % 3;
                                        REP(t, 0, 5){
                                                int nx = x + dir[t][0], ny = y + dir[t][1];
                                                if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;
                                                bd[nx][ny] ^= 1;
                                        }
                                }
                        }
                        bool ok = 1;
                        REP(i, 0, 3) REP(j,0,3){
                                if (bd[i][j] != obd[i][j]) ok = 0;
                        }
                        if(ok) ans = min(ans, cnt);
                }
                printf("%d\n", ans);
        }
        return 0;
}

