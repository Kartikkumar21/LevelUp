// https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1
int maxLen(int arr[], int N)
{
    if (N == 0)
        return 0;
    int len = 0;
    unordered_map<int, int> map;   // sum , index
    map[0] = -1;

    int sum = 0;
    for (int i = 0; i < N; i++)
    {
        int val = arr[i];
        if(val == 0) val = -1;
        sum += val;

        if(map.find(sum) != map.end()) len = max(len, i - map[sum]);
        else map[sum] = i;
    }

    return len;
}

