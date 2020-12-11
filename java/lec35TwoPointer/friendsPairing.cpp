int friendsPairing(int n, vector<int> &dp)
{
    if (n <= 1)
    {
        return dp[n] = 1;
    }

    if (dp[n] != 0)
        return dp[n];

    int single = friendsPairing(n - 1, dp);
    int pairUp = friendsPairing(n - 2, dp) * (n - 1);

    return dp[n] = single + pairUp;
}

int friendsPairing(int N, vector<int> &dp)
{

    int c = (int)1e9 + 7;
    for (int n = 0; n <= N; n++)
    {
        if (n <= 1)
        {
            dp[n] = 1;
            continue;
        }

        // int single = dp[n-1];//friendsPairing(n - 1, dp);
        // int pairUp = dp[n-2]*(n-1);//friendsPairing(n - 2, dp) * (n - 1);

        // dp[n] = single + pairUp;

        dp[n] = (dp[n - 1] % c + (dp[n - 2] % c * (n - 1) % c) % c) % c;
    }

    return dp[N];
}
int friendsPairing()
{
    int n = 10;
    vector<int> dp(n + 1, 0);
}