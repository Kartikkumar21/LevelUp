// leetcode 1191
class Solution {
    public int mod= (int)1e9 + 7;
// Best method
 
public long kadanesSum(int[] arr,int k){
    int gMaxSum = 0, runningSum = 0;
    int n = arr.length;
    
    for(int i = 0; i < n * k; i++){
        runningSum = (runningSum + arr[i % n]) % mod;
        
        if(runningSum > gMaxSum) gMaxSum = runningSum;
        
        if(runningSum <= 0) runningSum = 0;
    }

    return gMaxSum % mod;
}

public int kConcatenationMaxSum(int[] arr, int k) {
    long prevSum = 0;
    for(int i = 1 ; i <= k && i <= 3;i++){
        long KSum =  kadanesSum(arr, i);
        if(i == k) return (int)KSum;
        
        if(i == 3){
            return (int)((prevSum + (k - 2) * (KSum - prevSum)) % mod);
        }

        prevSum = KSum;
    }
    return  0;
}
}
