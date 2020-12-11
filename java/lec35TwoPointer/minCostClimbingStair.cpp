int minCostClimbingStairs(int n, vector<int> &cost, vector<int> &dp)
{
    if (n <= 1)
        return dp[n] = cost[n];

    if (dp[n] != 0)
        return dp[n];

    int val = min(minCostClimbingStairs(n - 1, cost, dp), minCostClimbingStairs(n - 2, cost, dp));

    return dp[n] = val + ((n < cost.size()) ? cost[n] : 0);
}

int minCostClimbingStairs(vector<int> &cost)
{
    if (cost.size() == 0)
        return 0;

    int n = cost.size();
    vector<int> dp(n + 1, 0);

    return minCostClimbingStairs(n, cost, dp);
}