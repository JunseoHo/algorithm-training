#include <iostream>
#include <queue>

/*
 * 9 3
 * 3 1
 *
 * 위와 같이 작은 물고기가 있지만 먹지 못하는 경우를 고려하지 못해 시간이 오래 걸렸다.
 */

int N;
int **space;
int size;
int eatCount;
int simulationTime;
bool **visited;
int position[2];
int next[3];
int candidate[2];

void initNext()
{
    next[0] = -1;
    next[1] = -1;
    next[2] = 2147483647;
}

void initVisited()
{
    visited = new bool*[N];
    for (int i = 0; i < N; i++)
        visited[i] = new bool[N];
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            visited[i][j] = false;
}

void move(int row, int col, std::queue<int*> *que, int dist)
{
    if (space[row][col] <= size)
    {
        que->push(new int[]{row, col, dist + 1});
        visited[row][col] = true;
        if (space[row][col] != 0
            && space[row][col] < size)
        {
            if (next[0] == -1 && next[1] == -1)
            {
                // std::cout << "Change : [" << next[0] << ", " << next[1] << "] -> [" << row << ", " << col << "]" << std::endl;
                next[0] = row;
                next[1] = col;
                next[2] = dist + 1;
            }
            else
            {
                int d1 = next[2];
                int d2 = dist + 1;
                if (d1 == d2)
                {
                    if (next[0] > row)
                    {
                        // std::cout << "Change : [" << next[0] << ", " << next[1] << "] -> [" << row << ", " << col << "]" << std::endl;
                        next[0] = row;
                        next[1] = col;
                        next[2] = d2;
                    }
                    else if (next[0] == row)
                    {
                        if (next[1] > col)
                        {
                            // std::cout << "Change : [" << next[0] << ", " << next[1] << "] -> [" << row << ", " << col << "]" << std::endl;
                            next[0] = row;
                            next[1] = col;
                            next[2] = d2;
                        }
                    }
                }
                else if (d1 > d2)
                {
                    // std::cout << "Change : [" << next[0] << ", " << next[1] << "] -> [" << row << ", " << col << "]" << std::endl;
                    next[0] = row;
                    next[1] = col;
                    next[2] = d2;
                }
            }
        }
    }
}

void findNext()
{
    initNext();
    initVisited();
    std::queue<int*> que;
    que.push(new int[]{position[0], position[1], 0});
    visited[position[0]][position[1]] = true;
    while (!que.empty())
    {
        int *loc = que.front();
        que.pop();
        if (loc[0] > 0 && !visited[loc[0] - 1][loc[1]])
            move(loc[0] - 1, loc[1], &que, loc[2]);
        if (loc[1] > 0 && !visited[loc[0]][loc[1] - 1])
            move(loc[0], loc[1] - 1, &que, loc[2]);
        if (loc[1] < N - 1 && !visited[loc[0]][loc[1] + 1])
            move(loc[0], loc[1] + 1, &que, loc[2]);
        if (loc[0] < N - 1 && !visited[loc[0] + 1][loc[1]])
            move(loc[0] + 1, loc[1], &que, loc[2]);
    }
}

int main(void)
{
    // init 
    std::cin >> N;
    space = new int*[N];
    for (int i = 0; i < N; i++)
        space[i] = new int[N];
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
        {
            std::cin >> space[i][j];
            if (space[i][j] == 9)
            {
                position[0] = i;
                position[1] = j;
            }
        }
    size = 2;
    eatCount = 0;
    simulationTime = 0;
    // solve
    next[0] = -1;
    next[1] = -1;
    while (true)
    {
        findNext();
        if (next[0] == -1 && next[1] == -1)
            break;
        // std::cout << next[0] << ", " << next[1] << std::endl;
        simulationTime += next[2];
        space[position[0]][position[1]] = 0;
        /*
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                std::cout << space[i][j] << ' ';
            }
            std::cout << std::endl;
        }
        */
        //std::cout << "(" << position[0] << ", " << position[1] << ") -> (" << next[0] << ", " << next[1] << ")" << std::endl;
        position[0] = next[0];
        position[1] = next[1];
        space[position[0]][position[1]] = 0;
        eatCount++;
        if (size == eatCount)
        {
            ++size;
            // std::cout << "Size up : " << size << std::endl;
            eatCount = 0;
        }
    }
    std::cout << simulationTime << '\n';
   /*for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            std::cout << space[i][j] << ' ';
        }
        std::cout << std::endl;
    }*/
    // free resource
    for(int i = 0; i < N; i++)
        delete[] space[i];
    delete[] space;
    return 0;
}

/*
0 0 0 0 0 0
0 0 6 0 0 0
0 0 5 0 0 0
0 0 0 0 0 0
0 0 0 0 0 9
0 0 0 0 0 0

Size : 7
Eat : 0
Dist : 9 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 2 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 2 + 6


*/