// leetcode 1004
class Solution {
    public int longestOnes(int[] arr, int K) {
            
    int n = arr.length, ei = 0, si = 0, len = 0;
    int zeroCount  = 0;
    while(ei < n){
        if(arr[ei++] == 0) zeroCount++;
        
        while(zeroCount > K){
            if(arr[si++] == 0) zeroCount--;    
        }
        
        len = Math.max(len, ei - si);
    }
    return len;
    }
}