class Btree{
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
    public static int size(Node node){
        return node==null? 0 : size(node.left)+size(node.right)+1;
    }
    public static int hieght(Node node){
        return node==null? -1 : Math.max(hieght(node.left),hieght(node.right))+1;
    }
    public static boolean find(Node node,int data){
        if(node==null){
            return false;
        }
        if(node.data==data){
            return true;
        }
        return find(node.left,data) || find(node.right,data);

    }
    public static void display(Node node){
        if(node==null){
            return;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(node.left==null?".":node.left.data+"");
        sb.append("<-"+node.data+"->");
        sb.append(node.right==null?".":node.right.data+"");
        System.out.println(sb);
        display(node.left);
        display(node.right);
    }
    public static void main(String[] args){
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root=constTree(arr);
        display(root);
        System.out.println(size(root));
        System.out.println(hieght(root));
        System.out.println(find(root,1));
    }
}