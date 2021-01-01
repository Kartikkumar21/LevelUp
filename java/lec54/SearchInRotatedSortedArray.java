// leetcode 33
public int search(int[] arr, int data) {
    int lo = 0, hi = arr.length - 1;
    while(lo <= hi){
        int mid = (hi + lo) / 2;
        
        if(arr[mid] == data) return mid;
        else if(arr[lo] <= arr[mid]){
            if(arr[lo] <= data && data < arr[mid]) hi = mid - 1;
            else lo = mid + 1; 
        }else{
            if(arr[mid] < data && data <= arr[hi]) lo = mid + 1;
            else hi = mid - 1;
        }
    }
    
    return -1;
}