int goldMine(int r, int c, int n, int m, vector<vector<int>> &arr, vector<vector<int>> &dp, vector<vector<int>> &dir)
{
    if (c == m - 1)
    {
        return dp[r][c] = arr[r][c];
    }

    if (dp[r][c] != 0)
        return dp[r][c];

    int maxVal = 0;
    for (int d = 0; d < 3; d++)
    {
        int x = r + dir[d][0];
        int y = c + dir[d][1];

        if (x >= 0 && y >= 0 && x < n && y < m)
        {
            maxVal = max(maxVal, goldMine(x, y, n, m, arr, dp, dir) + arr[r][c]);
        }
    }

    return dp[r][c] = maxVal;
}

int goldMineDP(int R, int C, int n, int m, vector<vector<int>> &arr, vector<vector<int>> &dp, vector<vector<int>> &dir)
{
    for (int c = C - 1; c >= 0; c--)
    {
        for (int r = R - 1; r >= 0; r--)
        {
            if (c == m - 1)
            {
                dp[r][c] = arr[r][c];
                continue;
            }

            int maxVal = 0;
            for (int d = 0; d < 3; d++)
            {
                int x = r + dir[d][0];
                int y = c + dir[d][1];

                if (x >= 0 && y >= 0 && x < n && y < m)
                {
                    maxVal = max(maxVal, dp[x][y] + arr[r][c]);
                }
            }

            dp[r][c] = maxVal;
        }
    }

    int maxVal = 0;
    for (int r = 0; r < n; r++)
    {
        maxVal = max(maxVal, dp[r][0]);
    }
}

void goldMine()
{
    vector<vector<int>> arr;
    int n = arr.size();
    int m = arr[0].size();

    vector<vector<int>> dp(n, vector<int>(m, 0));
    vector<vector<int>> dir{{-1, 1}, {0, 1}, {1, 1}};

    int maxVal = 0;
    for (int r = 0; r < n; r++)
    {
        maxVal = max(maxVal, goldMine(r, 0, n, m, arr, dp, dir));
    }

    cout << maxVal << endl;
}