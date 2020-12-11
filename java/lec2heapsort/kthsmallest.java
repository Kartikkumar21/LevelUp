import java.util.*;
class kthlargestinarray{
    public int findKthSmallest(int[] nums, int k) {
        // PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverse()); // by default min -> max

        // PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{  // this, other
        //     return b - a;     // this - other -> default, other - this -> reverse of default
        // }); // by default min -> max


        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b - a;
        });

        for(int ele: nums){
            pq.add(ele);
            if(pq.size()>k) pq.remove();
        }

        return pq.remove();
    }
}
