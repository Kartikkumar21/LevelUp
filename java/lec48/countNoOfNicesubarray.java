// leetcode 1248
class Solution {
    public int numberOfSubarraysAtMost(int[] arr, int k) {
        int n=arr.length;
        int si=0,ei=0,res=0,oddCount=0;
        
        while(ei<n){
            if((arr[ei++] & 1) !=0) oddCount++;
            
            while(oddCount> k){
                if((arr[si++] & 1) !=0) oddCount--;
            }
            
            res+=ei-si;
        }
        return res;
    }
    public int numberOfSubarrays(int[] arr, int k){
        int n=arr.length;
        if(n==0)return 0;
        return numberOfSubarraysAtMost(arr,k) - numberOfSubarraysAtMost(arr,k - 1);
    }
}