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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        if(root.val == sum && root.left == null && root.right == null)
            return true;
        
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val); 
    }


// PATHSUM II

 public void pathSum(TreeNode root, int sum,List<List<Integer>> res,List<Integer> ans) {
        if(root == null){
            return;
        }
        if(root.left==null && root.right ==null && sum-root.val==0){
            List<Integer> base=new ArrayList<>(ans);
            base.add(root.val);
            res.add(base);
            return;
        }
        ans.add(root.val);
        pathSum(root.left,sum-root.val,res,ans);
        pathSum(root.right,sum-root.val,res,ans);
        ans.remove(ans.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> res=new ArrayList<>();
        pathSum(root,sum,res,new ArrayList<>());
        return res;
    }
}