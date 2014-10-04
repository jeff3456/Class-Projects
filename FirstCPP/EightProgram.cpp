/*
 * EightProgram.cpp
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

char gd[30][30];
int dir[8][2] = { 1, 0, -1, 0, 0, 1, 0, -1, 1, 1, 1, -1, -1, 1, -1, -1 };
int main(){
        int num = 0;
        REP(i, 0, 8) {
                scanf("%s", &gd[i + 10][10]);
        }
        bool ok = 1;
        REP(i, 0, 8) REP(j, 0, 8){
                if (gd[i + 10][j + 10] == '*') num++;
                REP(t, 0, 8){
                        int cnt = 0;
                        REP(k, 0, 8){
                                if (gd[10 + i + dir[t][0]*k][10 + j + dir[t][1]*k] == '*') cnt++;
                        }
                        if (cnt >= 2) ok = 0;
                }
        }
        if (num != 8) ok = 0;
        puts(ok ? "valid" : "invalid");
        return 0;
}


