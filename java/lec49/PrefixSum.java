// sum from starting
public long prefixSum(int[] arr){
    long gSum = -(int)1e9;
    long cSum = 0;
    for(int ele : arr){
        cSum = (cSum + ele) % mod;
        gSum = Math.max(gSum, cSum); 
    }

    return gSum;
}

// sum from last
public long suffixSum(int[] arr){
    long gSum = -(int)1e9;
    long cSum = 0;
    for(int i = arr.length - 1; i >= 0; i--){
        cSum = (cSum + arr[i]) % mod;
        gSum = Math.max(gSum, cSum); 
    }

    return gSum;
}

public int kConcatenationMaxSum(int[] arr, int k) {
    long KadanesSum = kadanesAlgo(arr) % mod;
    if(k == 1) return (int)KadanesSum;

    long sumOfArray = 0;
    for(int ele : arr) sumOfArray += ele;

    long prefixSum = prefixSum(arr);
    long suffixSum = suffixSum(arr);

    if(sumOfArray > 0){
        long APSum = ((k - 2) * sumOfArray  % mod + suffixSum % mod + prefixSum % mod) % mod;
        return (int)Math.max(APSum, KadanesSum);
    }else{
        return (int)(Math.max(suffixSum + prefixSum, KadanesSum));
    }
}

// Best method
 
public long kadanesSum(int[] arr,int k){
    int gMaxSum = 0, runningSum = 0;
    int n = arr.length;
    
    for(int i = 0; i < n * k; i++){
        runningSum = (runningSum + arr[i % n]) % mod;
        
        if(runningSum > gMaxSum) gMaxSum = runningSum;
        
        if(runningSum <= 0) runningSum = 0;
    }

    return gMaxSum % mod;
}