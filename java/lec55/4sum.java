// leetcode 18
public List<List<Integer>> fourSum(int[] arr, int target) {
    if(arr.length < 4) return new ArrayList<>();
    Arrays.sort(arr);
    int n = arr.length;
    List<List<Integer>> ans = new ArrayList<>();

for(int i = 0; i < n;i++){
    if(i > 0 && arr[i] == arr[i - 1]) continue;
    
    for(int j = i + 1; j < n;j++){
        if(j > i + 1 && arr[j] == arr[j - 1]) continue;

        int k = j + 1, l  = n - 1;
        while(k < l){
            int sum = arr[i] + arr[j] + arr[k] + arr[l];
            if(sum == target){
                ans.add(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                k++;
                l--;

                while(k < l && arr[k] == arr[k - 1]) k++;
                while(k < l && arr[l] == arr[l + 1]) l--;

            }else if(sum < target) 
                k++;
            else 
                l--; 
        }
    }
}
return ans;     
}