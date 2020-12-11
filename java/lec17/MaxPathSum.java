// https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
    static int maxLL = -(int)1e8;
    public static int leafToLeaf(Node node){
        if(node==null) return -(int)1e8;
        if(node.left == null && node.right == null ) return node.data;

        int nodeToLeafLeft = leafToLeaf(node.left);
        int nodeToLeafRight = leafToLeaf(node.right);

        if(node.left != null && node.right !=null){
            maxLL = Math.max(maxLL,nodeToLeafLeft + nodeToLeafRight + node.data);
        }
        
        return Math.max(nodeToLeafLeft,nodeToLeafRight) + node.data;
    }