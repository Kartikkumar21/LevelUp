class AVLconst{
    public static class Node{
        int data=0;
        Node right=null;
        Node left=null;

        int bal=-1;
        int hieght=-1;
        Node(int data){
            this.data=data;
        }
    }
    public static void updateHeightAndBalance(Node node){
        int lh=-1;
        int rh=-1;
        if(node.left!=null){
            lh=node.left.hieght;
        }
        if(node.right!=null){
            rh=node.right.hieght;
        }
        node.bal=lh-rh;
        node.hieght=Math.max(lh,rh)+1;
    }
    public static Node rightRotation(Node A){   //0(1)
    Node B = A.left;
    Node BKaRight = B.right;

    B.right = A;
    A.left = BKaRight;

    updateHeightAndBalance(A);
    updateHeightAndBalance(B);

    return B;
    }

    public static Node leftRotation(Node A){  //0(1)
    Node B = A.right;
    Node BKaLeft = B.left;

    B.left = A;
    A.right = BKaLeft;

    updateHeightAndBalance(A);
    updateHeightAndBalance(B);

    return B;
    }
    public static Node getRotation(Node node){
        updateHeightAndBalance(node);
        if(node.bal==2){
            if(node.left.bal==1){
                return rightRotation(node); 
            }
            else{
                node.left = leftRotation(node.left);
                return rightRotation(node);
            }
        }
        else if(node.bal==-2){
            if(node.left.bal==-1){
                node.right = rightRotation(node.right);
                return leftRotation(node);
            }
            else{
                return leftRotation(node);
            }
        }
        return node; 
    }
    //=================================================================================
    public static Node insertIntoBST(Node node, int data) {
    if(node==null){
        return new Node(data);
    }
    if(data<node.data) node.left=insertIntoBST(node.left,data);
    else node.right=insertIntoBST(node.right,data);
    node= getRotation(node);
    return node;
    } 

    public static int Maxdata(Node node){
        while(node.right!=null) node=node.right;
        return node.data;
    }

    public static  Node deleteNode(Node node, int data) {
        if(node==null){
            return null;
        }
        if(data<node.data) node.left=deleteNode(node.left,data);
        else if(data>node.data) node.right=deleteNode(node.right,data);
        else{
            if(node.left==null || node.right==null){
                node=node.left!=null?node.left:node.right;
                return node;
            }
            int mdata=Maxdata(node.left);
            node.data=mdata;
            node.left=deleteNode(node.left,mdata);
        }
        node= getRotation(node);
        return node;
    }
    public static void display(Node node){
    if (node == null)
        return;

    StringBuilder str = new StringBuilder();
    str.append(node.left != null ? toString(node.left.data) : ".");
    str.append (" <- " + toString(node.data) + " . ");
    str.append (node.right != null ? toString(node.right.data) : ".");

    System.out.print(str);

    display(node.left);
    display(node.right);
}
public static void solve()
{
    Node node = null;
    for (int i = 1; i <= 14; i++)
        node = insertIntoBST(node, i *10);

    display(node);
}

public static void  main(String[] args)
{
    solve();
}
} 