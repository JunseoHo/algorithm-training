#include<string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s)
{
    int stack = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == '(')
            stack++;
        else
        {
            if (stack == 0)
                return false;
            else
                stack--;
        }
    }
    return stack == 0;
}