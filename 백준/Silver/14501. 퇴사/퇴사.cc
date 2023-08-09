#include <iostream>
#include <algorithm>

using namespace std;

int N;
int T[16];
int P[16];
int dpTable[17];

int extractMax(int *dpTable, int day) {
    int res = 0;
    for (int idx = 1; idx <= day; idx++)res = max(dpTable[idx], res);
    return res;
}

int main(void) {
    // init
    cin >> N;
    for (int idx = 1; idx < N + 1; ++idx) {
        scanf("%d %d", T + idx, P + idx);
    }
    // solve
    for (int day = 1; day < N + 2; ++day) {
        dpTable[day] = extractMax(dpTable, day);
        if (day < N + 1 && dpTable[day + T[day]] < dpTable[day] + P[day]) dpTable[day + T[day]] = dpTable[day] + P[day];
    }
    // print
    cout << dpTable[N + 1] << endl;
}