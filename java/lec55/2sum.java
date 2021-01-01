// leetcode 001

public int[] twoSum(int[] nums, int target) {    
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i = 0;i<nums.length;i++){
        int ele = nums[i];
        if(map.containsKey(target - ele)) return new int[]{map.get(target-ele),i};
        
        map.put(ele,i);
    }
    
    return new int[]{-1,-1};
}

public int[] twoSum(int[] arr, int data) {
        
    int si = 0, ei = arr.length - 1;
    while(si < ei){
        int sum = arr[si] + arr[ei];
        if(sum == data) return new int[]{si + 1,ei + 1};
        else if(sum < data) si++;
        else ei--;
    }
    return new int[]{-1,-1};
}