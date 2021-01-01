// leetcode 904
class Solution {
public:
    
int totalFruit_(vector<int> &arr)
{
    int n = arr.size();
    int si = 0, ei = 0, count = 0, len = 0;
    vector<int> freq(40002, 0); // 1 <= arr.length, arr[i] <= 40000

    while (ei < n)
    {
        if (freq[arr[ei++]]++ == 0)
            count++;

        while (count > 2)
        {
            if (freq[arr[si++]]-- == 1)
                count--;
        }
        len = max(len, ei - si);
    }
    return len;
}

int totalFruit(vector<int> &tree)
{
    return totalFruit_(tree);
}
};