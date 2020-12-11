import java.util.ArrayList;
class AllNodeDistK{
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
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K){
        
    }
    public static void main(String[] args){
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root=constTree(arr);
        display(root);
    }
}