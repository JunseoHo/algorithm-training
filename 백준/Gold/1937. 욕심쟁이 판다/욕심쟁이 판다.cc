#include <iostream>
using namespace std;

int 	N;
int		**map;
int		**dpTable;
int		answer;
int		dirRow[4] = {-1, 1, 0, 0};
int		dirCol[4] = {0, 0, -1, 1};

int trace(int row, int col)
{
	if (dpTable[row][col] != -1)
		return dpTable[row][col];
	int maxMoved = 0;
	for (int i = 0; i < 4; i++)
	{
		int nextRow = row + dirRow[i];
		int nextCol = col + dirCol[i];
		if (nextRow > -1 && nextRow < N
			&& nextCol > -1 && nextCol < N
			&& map[row][col] < map[nextRow][nextCol])
		{
			maxMoved = std::max(trace(nextRow, nextCol) + 1, maxMoved);
		}
	}
	return dpTable[row][col] = maxMoved;
}

int	main(void)
{
	// init map
	std::cin >> N;
	map = new int*[N];
	for (int i = 0; i < N; i++)
		map[i] = new int[N];
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			std::cin >> map[i][j]; 
	// init dpTable
	dpTable = new int*[N];
	for (int i = 0; i < N; i++)
		dpTable[i] = new int[N];
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			dpTable[i][j] = -1; 
	// init visited
	//visited = new bool*[N];
	//for (int i = 0; i < N; i++)
	//	visited[i] = new bool[N];
	//for (int i = 0; i < N; i++)
	//	for (int j = 0; j < N; j++)
	//		visited[i][j] = false;
	// init maxMoved
	answer = 0;
	// solve
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (dpTable[i][j] == -1)
			{
				//visited[i][j] = true;
				answer = std::max(trace(i, j), answer);
				//std::cout << ">> " << i << " " << j << std::endl;
				//for (int k = 0; k < N; k++)
				//{
				//	for (int l = 0; l < N; l++)
				//	{
				//		std::cout << dpTable[k][l] << " ";
				//	}
				//	std::cout << std::endl;	
				//}
				//for (int k = 0; k < N; k++)
				//	for (int l = 0; l < N; l++)
				//		visited[k][l] = false;
			}
		}
	}
	//for (int k = 0; k < N; k++)
	//{
	//	for (int l = 0; l < N; l++)
	//	{
	//		std::cout << dpTable[k][l] << " ";
	//	}
	//	std::cout << std::endl;
	//}		
	// print
	std::cout << answer + 1 << std::endl;
}



