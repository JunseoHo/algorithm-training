#include <iostream>
using namespace std;

int *treeMin;
int *treeMax;

int* buildTree(int index, int begin, int end, int* arr)
{
    if (begin == end)
    {
        treeMin[index] = arr[begin];
        treeMax[index] = arr[begin];
        return new int[]{treeMin[index], treeMax[index]};
    }
    else
    {
        int mid = (begin + end) / 2;
        int* a = buildTree(index * 2 + 1, begin, mid, arr);
        int* b = buildTree(index * 2 + 2, mid + 1, end, arr);
        treeMin[index] = min(a[0], b[0]);
        treeMax[index] = max(a[1], b[1]);
        return new int[]{treeMin[index], treeMax[index]};
    }
}

int* searchTree(int begin, int end, int index, int sectionBegin, int sectionEnd)
{
    if (sectionBegin > end || sectionEnd < begin) return nullptr;
    if (sectionBegin <= begin && sectionEnd >= end) return new int[]{treeMin[index], treeMax[index]};
    int mid = (begin + end) / 2;
    int* a = searchTree(begin, mid, index * 2 + 1, sectionBegin, sectionEnd);
    int* b = searchTree(mid + 1, end, index * 2 + 2, sectionBegin, sectionEnd);
    if (a == nullptr && b == nullptr) return nullptr;
    if (a == nullptr) return b;
    if (b == nullptr) return a;
    return new int[]{min(a[0], b[0]), max(a[1], b[1])};
}

int main(void)
{
    ios::sync_with_stdio(false);
    cout.tie(NULL), cin.tie(NULL);
    // init
    int N, M;
    cin >> N;
    cin >> M;
    int* arr = new int[N];
    for (int i = 0; i < N; i++) cin >> arr[i];
    treeMin = new int[N * 4];
    treeMax = new int[N * 4];
    buildTree(0, 0, N - 1, arr);
    int* mins = new int[M];
    int* maxs = new int[M];
    for (int i = 0; i < M; i++)
    {
        int sectionBegin, sectionEnd;
        cin >> sectionBegin;
        cin >> sectionEnd;
        sectionBegin--;
        sectionEnd--;
        int* answer = searchTree(0, N - 1, 0, sectionBegin, sectionEnd);
        mins[i] = answer[0];
        maxs[i] = answer[1];
    }
    for (int i = 0; i < M; i++)
    {
        cout << mins[i] << ' ' << maxs[i] << '\n';
    }
}
