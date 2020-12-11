//354
int maxEnvelopes(vector<vector<int>> &arr)
{

    int n = arr.size();
    vector<int> dp(n, 0);

    sort(arr.begin(), arr.end(), [](auto a, auto b) {
        if (a[1] == b[1])
            return b[0] < a[0];
        return a[1] < b[1]; // this - other, default behaviour.
    });

    int maxStack = 0;
    for (int i = 0; i < n; i++)
    {
        dp[i] = 1;
        for (int j = i - 1; j >= 0; j--)
        {
            if (arr[i][0] > arr[j][0])
                dp[i] = max(dp[i], dp[j] + 1);
        }

        maxStack = max(maxStack, dp[i]);
    }
    return maxStack;
}