int findNumberOfLIS(vector<int> &nums)
{
    int n = nums.size();
    if (n == 0)
        return 0;

    vector<int> dp(n, 0);
    vector<int> count(n, 0);

    int maxLen = 0, maxCount = 0;
    for (int i = 0; i < n; i++)
    {
        dp[i] = 1;
        count[i] = 1;
        for (int j = i - 1; j >= 0; j--)
        {
            if (nums[i] > nums[j])
            {
                if (dp[j] + 1 > dp[i])
                {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }
                else if (dp[j] + 1 == dp[i])
                {
                    count[i] += count[j];
                }
            }
        }

        if (dp[i] > maxLen)
        {
            maxLen = dp[i];
            maxCount = count[i];
        }
        else if (dp[i] == maxLen)
        {
            maxCount += count[i];
        }
    }

    return maxCount;
}