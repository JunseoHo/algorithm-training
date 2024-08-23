#include <string>
#include <vector>
#include <iostream>
#include <stack>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    stack<int> s;
    stack<int> lasts;
    for (int i = 0; i < numbers.size(); i++) {
        if (s.empty()) {
            answer.push_back(-1);
            s.push(numbers[i]);
            lasts.push(i);
        } else {
            while (!s.empty() && s.top() < numbers[i]) {
                s.pop();
                int last = lasts.top();
                lasts.pop();
                answer[last] = numbers[i];
            }
            answer.push_back(-1);
            s.push(numbers[i]);
            lasts.push(i);
        }
    }
    return answer;
}