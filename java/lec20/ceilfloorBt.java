class AllSolBt{
    public static class allsolpair{
        Node prev=null;
        Node pred=null;
        Node succ=null;

        int ceil=(int)1e9;
        int floor= -(int)1e9;
    }
    public static void allSolution(Node node,int data,allsolpair ans){
        if(node==null) return;

        if(node.data>data) ans.ceil=Math.min(ans.ceil,node.data);
        if(node.data<data) ans.floor=Math.max(ans.floor,node.data);

        allSolution(node.left,data,ans);
        if(node.data==data){
            ans.pred=ans.prev;
        }
        if(ans.prev !=null && ans.prev.data==data){
            ans.succ=node;
        }
        allSolution(node.right,data,ans);
    }
}