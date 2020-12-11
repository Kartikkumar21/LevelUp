int LDS(vector<int> &arr, vector<int> &dp)
{
    int n = arr.size();
    int maxLen = 0;
    for (int i = n - 1; i >= 0; i--)
    {
        dp[i] = 1;
        for (int j = i + 1; j < n; j++)
        {
            if (arr[i] > arr[j])
                dp[i] = max(dp[i], dp[j] + 1);
        }
        maxLen = max(maxLen, dp[i]);
    }

    return maxLen;
}