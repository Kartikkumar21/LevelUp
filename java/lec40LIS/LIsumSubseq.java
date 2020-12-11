
int LISumSubsequnece(vector<int> &arr, vector<int> &dp)
{
    int n = arr.size();
    int maxSum = 0;
    for (int i = 0; i < n; i++)
    {
        dp[i] = arr[i];
        for (int j = i - 1; j >= 0; j--)
        {
            if (arr[i] > arr[j])
                dp[i] = max(dp[i], dp[j] + arr[i]);
        }
        maxSum = max(maxSum, dp[i]);
    }

    return maxSum;
}