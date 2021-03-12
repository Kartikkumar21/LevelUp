// leetcode 283
   class Solution {
     private void swap(int i,int j,int nums[]) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void moveZeroes(int[] nums) {
        int idx = 0;
        int pi = -1;
        int n  = nums.length;
        while(idx < n) {
            if(nums[idx] != 0) {
                pi++;
                swap(pi,idx,nums);
            }
             idx++;
        }
           
        
    }
}

