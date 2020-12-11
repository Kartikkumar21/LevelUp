class singlenumber {
    public static int singleNumber(int[] nums) {
        int ans=0;
        for(int ele:nums){
            ans^=ele;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums={4,1,2,1,2};
        System.out.print(singleNumber(nums));
    }
}