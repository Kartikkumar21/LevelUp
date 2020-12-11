import java.util.*;
public class NodeToRootpath{
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
    public static ArrayList<Node> nodeToRootPath(Node node,int data){
        if(node==null) return null;

        if(node.data == data){
            ArrayList<Node> base = new ArrayList<>();
            base.add(node);
            return base;
        }

        ArrayList<Node> left = nodeToRootPath(node.left,data);
        if(left!=null){
            left.add(node);
            return left;
        }

        ArrayList<Node> right = nodeToRootPath(node.right,data);
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
        if(node.data==val){
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
    public static void main(String[] args){
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root=constTree(arr);
        // display(root);
        ArrayList<Node> ans=new ArrayList<>();
        System.out.println(node2root(root,90));
    }
}