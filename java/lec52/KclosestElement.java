// leetcode 658
class Solution {
    public int binarySearch(int[] arr,int data){
    int si = 0, ei = arr.length;
    while(si < ei){
        int mid = (si + ei) / 2; 
        if(data > arr[mid]) si = mid + 1;
        else ei = mid;
    }

    return si;
}
public List<Integer> findClosestElements(int[] A, int k, int x) {
    List<Integer> arr = new ArrayList<>();
    for(int ele : A) arr.add(ele);
    
    int n = A.length;
    
    if(x <= A[0]) return arr.subList(0,k);
    else if(x >= A[n - 1]) return arr.subList(n - k, n);
    else{
        
        int idx = binarySearch(A,x);   // where we suppose to find the x element.
        int si = Math.max(0,idx - k);
        int ei = Math.min(n - 1, idx + k);
        
        while((ei - si + 1) > k){
            if((x - A[si]) > (A[ei] - x)) si++;
            else ei--;
        }
        return arr.subList(si, ei + 1);
    }
}
}