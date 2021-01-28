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
    public static void kdown(Node node,Node block,int k,ArrayList<Integer> ans){
        if(node==null || node == block || k < 0) return;

        if(k==0){
            ans.add(node.data);
            return;
        }

        kdown(node.left,block,k-1,ans);
        kdown(node.right,block,k-1,ans);
    }

    public static void kFar(Node node,int data,int k){
       ArrayList<Node> list = new ArrayList<>();
       nodeToRootPath(node,data,list);

       ArrayList<Inreger> ans = new ArrayList<>();
       Node prev = null;
       for(int i=0;i<list.size();i++){
          kdown(list.get(i),prev,k-i,ans);
          prev = list.get(i);
       }
    }

    public static int kFar2(Node node,int data,int k,ArrayList<Integer> ans){
        if(node == null) return -1;

        if(node.data == data){
            kdown(node,null,k,ans);
            return 1;
        }

        int ld = kFar2(node.left, data, k, ans);
        if(ld != -1){
            kdown(node,node.left,k-ld,ans);
            return ld + 1;
        }

        int rd = kFar2(node.right, data, k, ans);
        if(rd != -1){
            kdown(node,node.right,k-rd,ans);
            return rd + 1;
        }

        return -1;
    }

    public static void main(String[] args){
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root=constTree(arr);
        display(root);
    }
}