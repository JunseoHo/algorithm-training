#include <iostream>

using namespace std;

int abs(int x) {
    return x < 0 ? x * (-1) : x;
}

int main(void) {
    // init
    int N;
    cin >> N;
    int *queue = new int[N];
    int front = 0;
    int rear = N - 1;
    for (int i = 0; i < N; ++i) queue[i] = i + 1;
    // solve
    while (abs(front - rear) > 1) {
        // dequeue
        if (front != rear) front = front == N - 1 ? 0 : front + 1;
        // dequeue and enqueue
        int element = queue[front];
        if (front != rear) front = front == N - 1 ? 0 : front + 1;
        if ((rear + 1) % N != front) {
            rear = rear == N - 1 ? 0 : rear + 1;
            queue[rear] = element;
        }
    }
    cout << queue[rear];
    // fin
    delete[] queue;
}
