// leetcode 1456
class Solution {
public:
    bool isVowel(char ch)
{
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
}

int maxVowels(string s, int k)
{
    int n = s.length();
    int si = 0, ei = 0, vowelsCount = 0, maxVowelsCount = 0;
    while (ei < n)
    {
        if (isVowel(s[ei++]))
            vowelsCount++;

        if ((ei - si) == k)
        {
            maxVowelsCount = max(maxVowelsCount, vowelsCount);
            if (isVowel(s[si++]))
                vowelsCount--;
        }
    }

    return maxVowelsCount;
}
};