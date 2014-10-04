/*
 * FlexibleSpaces.cpp
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

int W, N;
int sp[105];
int main(){
        cin >> W >> N;
        REP(i, 1, N+1) scanf("%d", sp + i);
        sp[0] = 0;
        sp[N+1] = W;
        N+=2;
        set<int> ans;
        REP(i, 0, N){
                REP(j, 0, N){
                        ans.insert(abs(sp[i] - sp[j]));
                }
        }
        set<int>::iterator r;
        for (r = ans.begin(); r != ans.end(); r++){
                if (*r > 0){
                        printf("%d ", *r);
                }
        }
        return 0;
}


