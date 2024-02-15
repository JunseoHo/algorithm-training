#include <iostream>
using namespace std;

int R, C;
char **matrix;

int	traverse(int i, int j, int count, bool* visited)
{
	if (visited[matrix[i][j] - 'A'])
		return count;
	visited[matrix[i][j] - 'A'] = true;
	
	int maxCount = count;
	if (i > 0)
		maxCount = max(maxCount, traverse(i - 1, j, count + 1, visited));
	if (i < R - 1)
		maxCount = max(maxCount, traverse(i + 1, j, count + 1, visited));
	if (j > 0)
		maxCount = max(maxCount, traverse(i, j - 1, count + 1, visited));
	if (j < C - 1)
		maxCount = max(maxCount, traverse(i, j + 1, count + 1, visited));
	visited[matrix[i][j] - 'A'] = false;
	return maxCount;
}

int	main(void)
{
	string line;
	const char*   c_arr;
	bool visited[26];
	cin >> R;
	cin >> C;

	matrix = new char*[R];
	for (size_t i = 0; i < R; i++)
		matrix[i] = new char[C];

	for (size_t i = 0; i < 26; i++)
		visited[i] = false;
	
	for (size_t i = 0; i < R; i++)
	{
		cin >> line;
		c_arr = line.c_str();
		for (size_t j = 0; j < C; j++)
		{
			matrix[i][j] = c_arr[j];
		}
	}
	if (R == 1 && C == 1)
	{
		cout << 1;
		return 0;
	}
	cout << traverse(0, 0, 0, visited);
	return 0;
}