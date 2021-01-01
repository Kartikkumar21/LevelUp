// leetcode 159
nt lengthOfLongestSubstringTwoDistinct(string s)
{
    int n = s.length();
    int si = 0, ei = 0, head = 0, len = 0, distinctCount = 0;

    vector<int> freq(128, 0);
    while (ei < n)
    {
        if (freq[s[ei++]]++ == 0)
            distinctCount++;

        while (distinctCount > 2)
            if (freq[s[si++]]-- == 1)
                distinctCount--;

        len = (ei - si > len) ? ei - (head = si) : len;
    }

    return len;
}
