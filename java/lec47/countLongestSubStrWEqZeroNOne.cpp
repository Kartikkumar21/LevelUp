int maxLen(int arr[], int N)
{
    if (N == 0)
        return 0;

    unordered_map<int, int> map;   // sum , index
    map[0] = 1;

    int sum = 0, count = 0;
    for (int i = 0; i < N; i++)
    {
        int val = arr[i];
        if(val == 0) val = -1;
        sum += val;
        count += map[sum];
        map[sum]++;

    }

    // for(pair<int,int> key : map){
    //     count += (key.second * (key.second - 1)) / 2;
    // }

    return count;
}