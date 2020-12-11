public static Node rightMostNode(Node node,Node curr){
        while(node.right != null && node.right != curr ){
            node = node.right;
        }
        return node;
    }

    public static void morrisInTraversal(Node node){
        Node curr = node;
        while(curr!=null){
            Node leftNode = curr.left;
            if(leftNode == null){  // left null
                System.out.print(curr.data);
                curr = curr.right;
            }else{
                Node rmost = rightMostNode(leftNode,curr);
                if(rmost.right == null){ // thread Creation
                    rmost.right = curr;
                    curr = curr.left;
                }else{  // thread Break
                    rmost.right = null;
                    System.out.print(curr.data);
                    curr = curr.right;
                }
            }
        }
    }