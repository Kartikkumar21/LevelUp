import java.util.*;
class KthLargest {
    //leet 703
    PriorityQueue<Integer> pq=new PriorityQueue<>();
        int K = 0;
    public KthLargest(int k, int[] nums) {
            this.K = k;
            for(int ele: nums){
                add(ele);
            }
    }    
    public int add(int val) {
            this.pq.add(val);
            if(this.pq.size() > K) 
               this.pq.remove();
            
            return this.pq.peek();
    }
}

