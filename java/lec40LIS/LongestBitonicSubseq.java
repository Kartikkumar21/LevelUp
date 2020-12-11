int LBS(vector<int> &arr)
{

    int n = arr.size();
    vector<int> DP_LIS(n, 0);
    vector<int> DP_LDS(n, 0);

    LIS(arr, DP_LIS);
    LDS(arr, DP_LDS);

    int maxLen = 0;
    for (int i = 0; i < n; i++)
    {
        maxLen = max(maxLen, DP_LIS[i] + DP_LDS[i] - 1);
    }

    return maxLen;
}