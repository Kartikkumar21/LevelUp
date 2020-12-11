class singleNoII {
    public static int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<32;i++){
            int count=0;
            int mask=(1<<i );
            for(int ele:nums){
                if((ele & mask) !=0)
                    count++;
            }
            if(count % 3 !=0)
                ans|=mask;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums={1,2,1,3,2};
        System.out.print(singleNumber(nums));
    }
}