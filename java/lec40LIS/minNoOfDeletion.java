int minNoOfDeletions(vector<int> &arr)
{
    int n = arr.size();
    vector<int> dp(n, 0);

    int maxLen = 0;
    for (int i = 0; i < n; i++)
    {
        dp[i] = 1;
        for (int j = i - 1; j >= 0; j--)
        {
            if (arr[i] >= arr[j])
                dp[i] = max(dp[i], dp[j] + 1);
        }
        maxLen = max(maxLen, dp[i]);
    }

    return n - maxLen;
}