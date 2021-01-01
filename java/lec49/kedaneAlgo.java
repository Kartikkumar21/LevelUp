class kedaneAlgo{
    public static int kedaneAlgo(int[] arr){
        int gmaxSum= -(int)1e8;
        int runningSum=0;
        for(int ele:arr){
            runningSum+=ele;
            if(runningSum> gmaxSum) gmaxSum=runningSum;

            if(runningSum<=0) runningSum=0;
        }
        return gmaxSum;
    }
}