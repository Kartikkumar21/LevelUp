public class node2root{
    public static class Node{
        int data=0;
        Node left=null;
        Node right=null;
        Node(int data){
            this.data=data;
        }
    }
    static int idx=0;
    public static Node constTree(int[] arr){
        if(idx>=arr.length || arr[idx]==-1){
            idx++;
            return null;
        }
        Node node=new Node(arr[idx++]);
        node.left=constTree(arr);
        node.right=constTree(arr);
        return node;
    }
    public static Node node2root(Node node,int val){
        if(node==null){
            return null;
        }
        if(node.data==val){
            ArrayList<Node> base=new ArrayList<>();
            base.add(node);
            return base;
        }
        ArrayList<Node> left=node2root(node.left,val);
            if(left!=null){
                left.add(node);
                return left;
            }
        ArrayList<Node> right=node2root(node.right,val);
            if(right!=null){
                right.add(node);
                return right;
            }
            return null;
    }
    public static boolean node2rootII(Node node,int val,ArrayList<Node> ans){
        if(node==null){
            return false;
        }
        if(node.data=val){
            ans.add(node);
            return true;
        }
        ans.add(node);
        boolean res=node2rootII(node.left,val,ans) || node2rootII(node.right,val,ans);
        if(!res){
            ans.remove(ans.size()-1);
        }
        return res;
    }
    public static void Lca(Node node,int a,int b){
        ArrayList<Node> list1=node2root(node,a);
        ArrayList<Node> list2=node2root(node,b);
        int i=list1.size()-1;
        int j=list2.size()-1;
        Node Lca=null;
        while(i>=0 && j>=0){
            if(list1.get(i)==list2.get(j))
                Lca=list1.get(i);
            
            i--;
            j--;
        } 
        System.out.println(Lca.data);
    }
    public static void display(Node node){
        if(node==null){
            return ;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(node.left==null?".":node.left.data+"");
        sb.append("<-"+node.data+"->");
        sb.append(node.right==null?".":node.right.data+"");
        System.out.println(sb);
        display(node.left);
        display(node.right);
    }

    //  LCA BETTER 
    static Node LCA=null;
    public static boolean LCA_better(Node node,int d1,int d2){
        boolean sf=false;
        if(node.data==d1 || node.data==d2) return true;

        boolean lf=LCA_better(node.left,d1,d2);
        if(LCA!=null) return true;

        boolean rf=LCA_better(node.right,d1,d2);
        if(LCA!=null) return true;

        if((lf && rf) || (lf && sf) ||(rf && sf)){
            LCA=node;
        }

        return lf || rf || sf;
    }
    public static boolean LCA_better(Node node,int d1,int d2){
        LCA_better(node,d1,d2);
        return LCA;
    }
    
    public static void main(String[] args){
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root=constTree(arr);
        display(root);
    }
}