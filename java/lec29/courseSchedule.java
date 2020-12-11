//Leetcode 207

public boolean canFinish(int N, int[][] arr){
    ArrayList<Integer>[] graph = new ArrayList[N];
    for(int i=0;i<N;i++) graph[i] = new ArrayList<>();
    
    int[] indegree = new int[N];
    for(int[] a: arr){
        indegree[a[1]]++;
        graph[a[0]].add(a[1]);
    }
    
    LinkedList<Integer> que = new LinkedList<>();
    for(int i=0;i<N;i++) if(indegree[i]==0) que.addLast(i);

    int count = 0;
    while(que.size()!=0){
        int vtx = que.removeFirst();
        count++;
        for(int e : graph[vtx]){
            if(--indegree[e] == 0) que.addLast(e);
        }
    }
    return count == N;        
}