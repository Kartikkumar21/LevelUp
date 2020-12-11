// leetcode 974
public int subarraysDivByK(int[] arr, int k) {
    if(arr.length == 0) return 0;

   int[] map = new int[k + 1];
   map[0] = 1;
  
   int sum = 0,count = 0;
   for(int i = 0 ; i < arr.length ; i++){
       sum += arr[i];
       int SUM = (sum % k + k) % k;
       count += map[SUM];
       map[SUM]++;
   }

   return count;
}