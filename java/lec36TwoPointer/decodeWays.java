int numDecodings(string &s, int idx, vector<int> &dp)
{
    if (idx == s.length())
    {
        return dp[idx] = 1;
    }

    if (dp[idx] != -1)
        return dp[idx];

    char ch = s[idx];
    if (ch == '0')
        return dp[idx] = 0;

    int count = 0;
    count += numDecodings(s, idx + 1, dp);

    if (idx < s.length() - 1)
    {
        int num = (s[idx] - '0') * 10 + (s[idx + 1] - '0');
        if (num <= 26)
            count += numDecodings(s, idx + 2, dp);
    }
    return dp[idx] = count;
}

int numDecodingsDP(string &s, int idx, vector<int> &dp)
{

    for (idx = s.length(); idx >= 0; idx--)
    {
        if (idx == s.length())
        {
            dp[idx] = 1;
            continue;
        }

        char ch = s[idx];
        if (ch == '0')
        {
            dp[idx] = 0;
            continue;
        }

        int count = 0;
        count += dp[idx + 1];
        if (idx < s.length() - 1)
        {
            int num = (s[idx] - '0') * 10 + (s[idx + 1] - '0');
            if (num <= 26)
                count += dp[idx + 2];
        }
        dp[idx] = count;
    }

    return dp[0];
}

int numDecodingsOpti(string &s)
{
    int a = 1;  // for single call.
    int b = 0;  // for doubl character call.

    for (int idx = s.length() - 1; idx >= 0; idx--)
    {
        int sum = 0;
        char ch = s[idx];
        if (ch == '0')
            sum = 0;
        else
        {
            sum = a;
            if (idx < s.length() - 1)
            {
                int num = (s[idx] - '0') * 10 + (s[idx + 1] - '0');
                if (num <= 26)
                    sum += b;
            }
        }

        b = a;
        a = sum;
    }

    return a;
}

int numDecodings(string s)
{
    if (s.length() == 0 || s[0] == '0')
        return 0;

    vector<int> dp(s.length() + 1, -1);
    // return numDecodings(s, 0, dp);
    return numDecodingsDP(s, 0, dp);
}

