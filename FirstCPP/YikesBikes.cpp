/*
 * YikesBikes.cpp
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
struct pt{
	double x, y;
	pt(){}
	pt(double _x, double _y) {
		x = _x; y = _y;
	}
	pt operator + (pt ano){
		return pt(x + ano.x, y + ano.y);
	}
	pt operator - (pt ano){
		return pt(x - ano.x, y - ano.y);
	}
};
int main(){
	int T;
	cin >> T;
	while (T--){
		double M, B, D, T;
		cin >> M >> B >> D >> T;
		double sx = B*T;
		double t = 11 / M;
		pt c1 = pt(sx, -0.5);
		pt c2 = pt(sx + B*t, 10.5);
		pt v = c2 - c1;
		pt n = pt(-v.y, v.x);
		double len = sqrt(n.x*n.x + n.y*n.y);
		n.x /= len; n.y /= len;
		n.x *= 0.5; n.y *= 0.5;
		pt n2 = pt(-n.x, -n.y);
		pt d1 = c1 + n;
		pt d2 = c2 + n;
		pt d3 = c1 + n2;
		pt d4 = c2 + n2;
		bool never = 1;
		REP(i, 0, 10){
			pt a, b;
			bool ok = 1;
			double sl = D + i * 4, sr = sl + 2;
			double p;
			p = (d2.y - 5) / (d2.y - d1.y);
			double xl = p * d1.x + (1 - p) * d2.x;
			p = (d4.y - 5) / (d4.y - d3.y);
			double xr = p * d3.x + (1 - p) * d4.x;

			if (sl <= xr && sr >= xl) {
				printf("Collision with bicycle %d\n", i + 1);
				never = 0;
				break;
			}
			if (xr < sl) {
				if (i == 0){
					puts("Max beats the first bicycle");
				}
				else{
					printf("Max crosses safely after bicycle %d\n", i);
				}
				never = 0;
				break;
			}
		}
		if (never) {
			puts("Max crosses safely after bicycle 10");
		}

	}
	return 0;
}
