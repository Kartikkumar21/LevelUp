int mazePath_Multiple(int sr, int sc, int er, int ec, vector<vector<int>> &dp)
{
    if (sr == er && sc == ec)
    {
        return dp[sr][sc] = 1;
    }

    if (dp[sr][sc] != 0)
        return dp[sr][sc];

    int count = 0;
    for (int jump = 1; sr + jump <= er; jump++)
        count += mazePath_Multiple(sr + jump, sc, er, ec, dp);
    for (int jump = 1; sc + jump <= ec; jump++)
        count += mazePath_Multiple(sr, sc + jump, er, ec, dp);
    for (int jump = 1; sr + jump <= er && sc + jump <= ec; jump++)
        count += mazePath_Multiple(sr + jump, sc + jump, er, ec, dp);

    return dp[sr][sc] = count;
}

int mazePath_MultipleDP(int SR, int SC, int er, int ec, vector<vector<int>> &dp)
{
    for (int sr = er; sr >= 0; sr--)
    {
        for (int sc = ec; sc >= 0; sc--)
        {

            if (sr == er && sc == ec)
            {
                dp[sr][sc] = 1;
                continue;
            }

            int count = 0;
            for (int jump = 1; sr + jump <= er; jump++)
                count += dp[sr + jump][sc]; //mazePath_Multiple(sr + jump, sc, er, ec, dp);
            for (int jump = 1; sc + jump <= ec; jump++)
                count += dp[sr][sc + jump]; //mazePath_Multiple(sr, sc + jump, er, ec, dp);
            for (int jump = 1; sr + jump <= er && sc + jump <= ec; jump++)
                count += dp[sr + jump][sc + jump]; //mazePath_Multiple(sr + jump, sc + jump, er, ec, dp);

            dp[sr][sc] = count;
        }
    }

    return dp[SR][SC];
}

void mazePath()
{
    int n = 4;
    int m = 4;
    vector<vector<int>> dp(n, vector<int>(m, 0)); // int[][] dp = new int[n][m];
    // cout << mazePath(0, 0, n - 1, m - 1, dp) << endl;
    // cout << mazePathDP(0, 0, n - 1, m - 1, dp) << endl;

    // cout << mazePath_Multiple(0, 0, n - 1, m - 1, dp) << endl;
    cout << mazePath_MultipleDP(0, 0, n - 1, m - 1, dp) << endl;

    print2D(dp);
}