int mod = 1e9 + 7;

long long numDecodings(string &s, int idx, vector<long long> &dp)
{
    if (idx == s.length())
        return dp[idx] = 1;
    if (s[idx] == '0')
        return dp[idx] = 0;
    if (dp[idx] != -1)
        return dp[idx];

    long long count = 0;
    char ch = s[idx];

    if (s[idx] == '*')
    {
        count = (count + 9 * numDecodings(s, idx + 1, dp) % mod) % mod;
        if (idx < s.length() - 1 && s[idx + 1] >= '0' && s[idx + 1] <= '6')
            count = (count + 2 * numDecodings(s, idx + 2, dp) % mod) % mod;
        else if (idx < s.length() - 1 && s[idx + 1] >= '7')
            count = (count + numDecodings(s, idx + 2, dp) % mod) % mod;
        else if (idx < s.length() - 1 && s[idx + 1] == '*')
            count = (count + 15 * numDecodings(s, idx + 2, dp) % mod) % mod;
    }
    else
    {
        count = (count + numDecodings(s, idx + 1, dp) % mod) % mod;
        if (idx < s.length() - 1 && s[idx + 1] == '*')
        {
            if (ch == '1')
                count = (count + 9 * numDecodings(s, idx + 2, dp) % mod) % mod;
            else if (ch == '2')
                count = (count + 6 * numDecodings(s, idx + 2, dp) % mod) % mod;
        }
        else if (idx < s.length() - 1)
        {
            int num = (ch - '0') * 10 + (s[idx + 1] - '0');
            if (num <= 26)
                count = (count + numDecodings(s, idx + 2, dp) % mod) % mod;
        }
    }

    return dp[idx] = count;
}

long long numDecodings(string &s)
{

    long long a = 1;
    long long b= 0;
    for (int idx = s.length() - 1; idx >= 0; idx--)
    {
        long long count = 0;
        char ch = s[idx];
        
        if(s[idx] == '0') count = 0;
        else if (s[idx] == '*')
        {
            count = (count + 9 * a % mod) % mod;
            if (idx < s.length() - 1 && s[idx + 1] >= '0' && s[idx + 1] <= '6')
                count = (count + 2 * b % mod) % mod;
            else if (idx < s.length() - 1 && s[idx + 1] >= '7')
                count = (count + b % mod) % mod;
            else if (idx < s.length() - 1 && s[idx + 1] == '*')
                count = (count + 15 * b % mod) % mod;
        }
        else
        {
            count = (count + a % mod) % mod;
            if (idx < s.length() - 1 && s[idx + 1] == '*')
            {
                if (ch == '1')
                    count = (count + 9 * b % mod) % mod;
                else if (ch == '2')
                    count = (count + 6 * b % mod) % mod;
            }
            else if (idx < s.length() - 1)
            {
                int num = (ch - '0') * 10 + (s[idx + 1] - '0');
                if (num <= 26)
                    count = (count + b % mod) % mod;
            }
        }

        b = a;
        a = count;
    }
    return a;
}

int numDecodings(string s)
{
    int n = s.length();
    if (n == 0)
        return 0;
    vector<int> dp(n + 1, -1);
    return numDecodings(s, 0, dp);
}