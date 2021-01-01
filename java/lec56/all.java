public static void makeAns(List<List<Integer>> ans,List<List<Integer>> smallAns){
    if(smallAns.size() > 0){
        for(List<Integer> al : smallAns){
            al.add(arr[i]);
            ans.add(al);
        }
    }
}

public static List<List<Integer>> twoSum(int[] arr,int data,int si,int ei){
    List<List<Integer>> ans = new ArrayList<>();
    int i = si, j = ei;
    while(i < j){
        int sum = arr[i] + arr[j];
        if(sum == data){
            ans.add(Arrays.asList(arr[i],arr[j]));
            i++;
            j--;

            while(i < j && arr[i] == arr[i - 1]) i++;
            while(i < j && arr[j] == arr[j + 1]) j--;
        }
        else if(sum < data) i++;
        else j--;
    }

    return ans;
}

public static List<List<Integer>> threeSum(int[] arr,int data,int si,int ei){
    List<List<Integer>> ans = new ArrayList<>();
    for(int i = si; i <= ei;i++){
        if(i != si && arr[i] == arr[i - 1]) continue;
        List<List<Integer>> smallAns = twoSum(arr,data - arr[i], i + 1, ei);
        makeAns(ans,smallAns);   
    }

    return ans;
}

public List<List<Integer>> fourSum(int[] arr, int data,int si,int ei) {
    List<List<Integer>> ans = new ArrayList<>();
    for(int i = si;i <= ei;i++){
        if(i != si && arr[i] == arr[i - 1]) continue;
        List<List<Integer>> smallAns = threeSum(arr,data - arr[i], i + 1, ei);
        makeAns(ans,smallAns);
    }

    return ans;
}

public List<List<Integer>> fourSum(int[] arr, int data) {
    if(arr.length < 4) return new ArrayList<>();
    Arrays.sort(arr);
    
    int n = arr.length;
    return fourSum(arr,data,0,n - 1);
}


//454
public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    HashMap<Integer,Integer> map = new HashMap<>();
    
    for(int e1: A){
        for(int e2 : B){
            map.put(e1 + e2, map.getOrDefault(e1+e2,0) + 1);
        }
    }
    
    int count = 0;
    for(int e1: C){
        for(int e2 : D){
            count += map.getOrDefault(-(e1 + e2),0);
        }
    }
    
    return count;    
}

public int twoSumCount(int[] A, int[] B) {
    Arrays.sort(A);
    Arrays.sort(B);

    int i = 0, j = B.length - 1;
    int ans = 0;

    while(i < A.length && j >= 0){
        int sum = A[i] + B[j];
        if(sum < 0) i++;
        else if(sum > 0) j--;
        else{
            int countA = 1, countB = 1;
            while(++i < A.length && A[i] == A[i - 1]) countA++;
            while(--j >= 0 && B[j] == B[j + 1]) countB++;

            ans += countA * countB;
        }
    }
}

public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
   int n = A.length;
   int[] ABcombination = new int[n*n];
   int[] CDcombination = new int[n*n];
   
   int k = 0;
   for(int i = 0;i<n;i++){
       for(int j = 0;j<n;j++){
        ABcombination[k] = A[i] + B[j];
        CDcombination[k] = C[i] + D[j];
        k++;
       }
   }

   return twoSumCount(ABcombination,CDcombination);
}