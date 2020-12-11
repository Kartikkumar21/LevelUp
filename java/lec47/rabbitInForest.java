// leetcode 781
public int numRabbits(int[] arr) {
    if(arr.length == 0) return 0;
    
    int n = arr.length;
    HashMap<Integer,Integer> map = new HashMap<>();
    
    int ans = 0;
    for(int ele : arr){
        if(!map.containsKey(ele)){
            ans += (ele + 1);
            map.put(ele, 1);
        }else{
            map.put(ele,map.get(ele) + 1);
        }
        
        if(map.get(ele) == ele + 1) map.remove(ele);
    }
    
    return ans;
}