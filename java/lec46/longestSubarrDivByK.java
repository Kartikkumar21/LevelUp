// https://www.geeksforgeeks.org/longest-subarray-sum-divisible-k/
int longSubarrWthSumDivByK(int arr[], int n, int k){
    if (n == 0)
        return 0;
        
    int len = 0;
    unordered_map<int, int> map;   // sum , index
    map[0] = -1;

    int sum = 0;
       for (int i = 0; i < n; i++)
      {
        sum += arr[i];

        int SUM = (sum % k + k) % k;
        if(map.find(SUM) != map.end()) len = max(len, i - map[SUM]);
        else map[SUM] = i;
       }

       return len;
}