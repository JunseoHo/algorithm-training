#include <iostream>

int main(void) {
    // init
    int N(0);
    int cycle(0);
    std::cin >> N;
    int M(N);
    int sum(0);
    // solve
    do {
        if (M > 9) sum = (M / 10) + (M % 10);
        else sum = M;
        M = ((M % 10) * 10) + (sum % 10);
        ++cycle;
    } while (N != M);
    // fin
    std::cout << cycle;
}