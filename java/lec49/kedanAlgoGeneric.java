class kedaneAlgoGeneric{
    public static int genericKedanes(int[] arr){
        int gmaxSum=arr[0];
        int runningSum=arr[0];
        for(int i=0;i<arr.length;i++){
            runningSum= Math.max(arr[i],runningSum+arr[i]);
            gmaxSum=Math.max(gmaxSum,runningSum);
        }
        return gmaxSum; 
    }
}