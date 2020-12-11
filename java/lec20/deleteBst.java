public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
class Solution {
    public int MaxVal(TreeNode root){
        while(root.right!=null) root=root.right;
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(val<root.val) root.left=deleteNode(root.left,val);
        else if(val>root.val) root.right=deleteNode(root.right,val);
        else{
            if(root.left==null || root.right==null){
                TreeNode node=root.left!=null?root.left:root.right;
                return node;
            }
            int mVal=MaxVal(root.left);
            root.val=mVal;
            root.left=deleteNode(root.left,mVal);
        }
        return root;
    }
}