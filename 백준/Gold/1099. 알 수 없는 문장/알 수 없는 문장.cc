#include <iostream>
#include <string>
#include <list>

int *dpTable;

bool equals(std::string s1, std::string s2)
{
    for (int i = 0; i < s1.size(); i++)
    {
        size_t found = s2.find(s1[i]);
        if (found == std::string::npos) return false;
        s2.erase(found, 1);
    }
    return s2.empty();
}

int match(std::string token, std::string word)
{
   if (!equals(token, word)) return -1;
    int cost = 0;
    for (int i = 0; i < token.size(); i++)
        if (token[i] != word[i]) ++cost;
    return cost;
}

void interpret(std::string sentence, int location, std::list<std::string> words, int pre)
{
    for(std::string word : words)
    {
       std::string token = sentence.substr(location, word.size());
        if (token.empty()) return;
        int cost = match(token, word);
       if (cost != -1)
       {
           if ((dpTable[location + word.size() - 1] == -1) || (dpTable[location + word.size() - 1] > pre + cost))
           {
               dpTable[location + word.size() - 1] = pre + cost;
               interpret(sentence, location + word.size(), words, pre + cost);
           }
       }
    }
}

int main(int argc, char* argv[])
{
    // initialize
    std::string sentence;
    int numberOfWords;
    std::list<std::string> words;
    std::cin >> sentence;
    std::cin >> numberOfWords;
    for (int i = 0; i < numberOfWords; i++)
    {
        std::string word;
        std::cin >> word;
        words.push_back(word);
    }
    dpTable = new int[sentence.size()];
    for (int i = 0; i < sentence.size(); i++) dpTable[i] = -1;
    // solve
    interpret(sentence, 0, words, 0);
    std::cout << dpTable[sentence.size() - 1] << std::endl;
    return 0;
}
