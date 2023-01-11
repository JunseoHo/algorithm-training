#include <stdio.h>
#pragma warning(disable:4996)
#ifndef max
#define max(a,b)  (((a) > (b)) ? (a) : (b))
#endif
#ifndef min
#define min(a,b)  (((a) < (b)) ? (a) : (b))
#endif

int main(void) {
	int N;
	int dpTable[2][3];
	int left;
	int center;
	int right;
	int postLeft;
	int postCenter;
	int postRight;
	scanf("%d", &N);
	scanf("%d %d %d", &left, &center, &right);
	dpTable[0][0] = left;
	dpTable[0][1] = center;
	dpTable[0][2] = right;
	dpTable[1][0] = left;
	dpTable[1][1] = center;
	dpTable[1][2] = right;
	for (int i = 1; i < N; i++) {
		scanf("%d %d %d", &left, &center, &right);
		postLeft = dpTable[0][0];
		postCenter = dpTable[0][1];
		postRight = dpTable[0][2];
		dpTable[0][0] = max(postLeft, postCenter) + left;
		dpTable[0][1] = max(max(postLeft, postCenter), postRight) + center;
		dpTable[0][2] = max(postCenter, postRight) + right;
		postLeft = dpTable[1][0];
		postCenter = dpTable[1][1];
		postRight = dpTable[1][2];
		dpTable[1][0] = min(postLeft, postCenter) + left;
		dpTable[1][1] = min(min(postLeft, postCenter), postRight) + center;
		dpTable[1][2] = min(postCenter, postRight) + right;
	}
	printf("%d %d", max(max(dpTable[0][0], dpTable[0][1]), dpTable[0][2]), min(min(dpTable[1][0], dpTable[1][1]), dpTable[1][2]));
	return 0;
}