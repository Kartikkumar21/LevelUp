//Leetcode 210
public int[] findOrder(int N, int[][] arr) {
    ArrayList<Integer>[] graph = new ArrayList[N];
     for(int i=0;i<N;i++) graph[i] = new ArrayList<>();
     
     int[] indegree = new int[N];
     for(int[] a: arr){
         indegree[a[1]]++;
         graph[a[0]].add(a[1]);
     }
     
     LinkedList<Integer> que = new LinkedList<>();
     for(int i=0;i<N;i++) if(indegree[i]==0) que.addLast(i);

     int[] ans = new int[N];
     int idx = N - 1;
     while(que.size()!=0){
         int vtx = que.removeFirst();
         ans[idx--] = vtx;
         
         for(int e : graph[vtx]){
             if(--indegree[e] == 0) que.addLast(e);
         }
     }
     
     
     if(idx == -1) return ans;
     return new int[0];
 }
