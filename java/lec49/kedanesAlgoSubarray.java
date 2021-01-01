class kedaneAlgoSubarray{
    public static int kedaneAlgo(int[] arr){
        int gmaxSum=-(int)1e8;
        int runningSum=0;
        int gsi=0,int gei=0, int rsi=0;
        for(int rei=0; rei<=arr.length;rei++){
            runningSum +=arr[rei];
            
            if(runningSum> gmaxSum){
                gmaxSum=runningSum;
                gsi=rsi;
                gei=rei;
            }

            if(runningSum<=0){
                runningSum=0;
                rsi=rei+1;
            }
        }
        return gmaxSum;
    }
}