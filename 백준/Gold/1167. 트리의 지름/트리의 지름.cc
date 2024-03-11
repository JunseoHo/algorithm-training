#include <iostream>
#include <list>
#include <vector>

class Node
{
public:
    std::vector<std::pair<int, int> *> adj;

    void addAdj(int i, int d)
    {
        std::pair<int, int>* node = new std::pair<int, int>();
        node->first = i;
        node->second = d;
        adj.push_back(node);
    }
};

class Farthest
{
public:
    int idx;
    int dist;
};

Node *graph;
int V;
int answer;
bool *visited;

Farthest findFarthestNode(int idx)
{
    visited[idx] = true;
    Farthest max;
    max.dist = 0;
    for (std::pair<int, int>* node : graph[idx].adj)
    {
        int dest = node->first;
        int dist = node->second;
        if (!visited[dest])
        {
            Farthest farthest = findFarthestNode(dest);
            farthest.dist += dist;
            if (max.dist < farthest.dist)
            {
               // std::cout << "From " << idx << ", " << "To " << farthest.idx << ", " << f
                max = farthest;
            }
        }
    }
    if (max.dist == 0)
        max.idx = idx;
    return max;
}

int main(void)
{
    // Init 
    std::cin >> V;
    graph = new Node[V];
    for (int i = 0; i < V; i++)
    {
        int src;
        std::cin >> src;
        --src;
        while (true)
        {
            int dest, dist;
            std::cin >> dest;
            if (dest == -1)
                break;
            --dest;
            std::cin >> dist;
            graph[src].addAdj(dest, dist);
        }
    }
    answer = 0;
    visited = new bool[V];
    for (int i = 0; i < V; i++) visited[i] = false;
    // solve
    Farthest y = findFarthestNode(0);
    for (int i = 0; i < V; i++) visited[i] = false;
    Farthest z = findFarthestNode(y.idx);
    answer = z.dist;
    // print
    std::cout << answer << std::endl;
}