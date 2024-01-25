#include <iostream>
using namespace std;

int		N, M, K;
long long		*seq;
long long		*segmentTree;
long long		*answers;

long long buildTree(int begin, int end, int treeIdx)
{
	if (begin == end) return segmentTree[treeIdx] = seq[begin];
	int mid = (begin + end) / 2;
	return segmentTree[treeIdx] = (buildTree(begin, mid, treeIdx * 2 + 1) % 1000000007)
			* (buildTree(mid + 1, end, treeIdx * 2 + 2) % 1000000007);
}

long long updateTree(int begin, int end, int treeIdx, int updatedIdx)
{
	if (updatedIdx < begin || updatedIdx > end) return segmentTree[treeIdx];
	if (begin == end) 
	{
		if (begin == updatedIdx)
			segmentTree[treeIdx] = seq[begin];
		return segmentTree[treeIdx];
	}
	int mid = (begin + end) / 2;
	return segmentTree[treeIdx] = ((updateTree(begin, mid, treeIdx * 2 + 1, updatedIdx) % 1000000007)
			* (updateTree(mid + 1, end, treeIdx * 2 + 2, updatedIdx) % 1000000007) % 1000000007);
}

long long queryTree(int begin, int end, int treeIdx, int left, int right)
{
	if (left > end || right < begin) return 1;
	if (left <= begin && right >= end) return segmentTree[treeIdx];
	if (begin == end) return segmentTree[treeIdx];
	int mid = (begin + end) / 2;
	return ((queryTree(begin, mid, treeIdx * 2 + 1, left, right) % 1000000007)
		* (queryTree(mid + 1, end, treeIdx * 2 + 2, left, right) % 1000000007) % 1000000007);
}

int	main(void)
{
	ios::sync_with_stdio(false);
    cout.tie(NULL), cin.tie(NULL);
	cin >> N;
	cin >> M;
	cin >> K;
	seq = new long long[N];
	segmentTree = new long long[N * 4];
	answers = new long long[K];
	for (int i = 0; i < N; i++) cin >> seq[i];
	buildTree(0, N - 1, 0);
	int k = 0;
	for (int i = 0; i < M + K; i++)
	{
		int a, b, c;
		cin >> a;
		cin >> b;
		cin >> c;
		if (a == 1)
		{
			seq[--b] = c;
			updateTree(0, N - 1, 0, b);
		} 
		else if (a == 2)
		{
			--b;
			--c;
			answers[k++] = queryTree(0, N - 1, 0, b, c) % 1000000007;
		}
	}
	for (int i = 0; i < K; i++) 
		cout << answers[i] << '\n';
	return 0;
}