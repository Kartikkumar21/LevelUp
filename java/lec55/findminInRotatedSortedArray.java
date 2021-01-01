// leetcode 153
class Solution {
    public int findMin(int[] arr) {
    int lo = 0, hi = arr.length - 1;
    if(arr[lo] <= arr[hi]) return arr[lo];
    
    while(lo < hi){
        int mid = (lo + hi) / 2;
        
        if(arr[mid] < arr[hi]) hi = mid;
        else if(arr[lo] <= arr[mid]) lo = mid + 1;
        // else lo++; // if ele is duplicate.
    }
    
    return arr[lo];
}
}