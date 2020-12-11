import java.util.ArrayList;
class LCAleetcode{
     public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
 
class Solution {
    public ArrayList<TreeNode> node2root(TreeNode node,int val){
        if(node==null){
            return null;
        }
        if(node.val==val){
            ArrayList<TreeNode> base=new ArrayList<>();
            base.add(node);
            return base;
        }
        ArrayList<TreeNode> left=node2root(node.left,val);
            if(left!=null){
                left.add(node);
                return left;
            }
        ArrayList<TreeNode> right=node2root(node.right,val);
            if(right!=null){
                right.add(node);
                return right;
            }
            return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         ArrayList<TreeNode> list1=new ArrayList<>();
            list1= node2root(root,p.val);
        ArrayList<TreeNode> list2=new ArrayList<>();
            list2=node2root(root,q.val);
        int i=list1.size()-1;
        int j=list2.size()-1;
        TreeNode Lca=null;
        while(i>=0 && j>=0){
            if(list1.get(i)==list2.get(j))
                Lca=list1.get(i);
            
            i--;
            j--;
        } 
        return Lca;
    }
}
}