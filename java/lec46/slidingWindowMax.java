// leetcode 239
class Solution {
public int[] maxSlidingWindow(int[] nums, int k) {
    if(nums.length == 1 || k == 1) return nums;

    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
        // return nums[a] - nums[b];  // this - other for default behaviour,min PQ.
        return nums[b] - nums[a];  // other - this for reverse of default behaviour,max PQ
    });


    int n = nums.length;
    int[] ans = new int[n - k + 1];
    int idx = 0;

    for(int i = 0;i<n;i++){
        while(pq.size() != 0 && pq.peek() <= i - k) pq.remove();
        pq.add(i);

        if(i >= k - 1) ans[idx++] = nums[pq.peek()];
    }

    return ans;
}
}