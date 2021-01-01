// leetcode 15
class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
    Arrays.sort(arr);
    int n = arr.length;
    int data = 0;
    List<List<Integer>> res = new ArrayList<>();
    
    for(int i = 0;i < n;i++){
        while( i != 0 && i < n && arr[i] == arr[i-1]) i++;
        int j = i + 1, k = n - 1;
        
        while(j < k){
            int sum = arr[i] + arr[j] + arr[k];
            if(sum == data){
                // List<Integer> ar = new ArrayList<>();
                // ar.add(arr[i]);
                // ar.add(arr[j]);
                // ar.add(arr[k]);
                // res.add(ar);
                
                res.add(Arrays.asList(arr[i],arr[j],arr[k]));
                
                j++;
                k--;
                
                while( j < k && arr[j] == arr[j-1]) j++;
                while( j < k && arr[k] == arr[k+1]) k--;
            }else if(sum < data)
                 j++;
            else 
                 k--;
        }
    }
    
    return res;
}
}