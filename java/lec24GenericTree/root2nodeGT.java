import java.util.*;
class root2nodeGT{
    public static class Node{
        int data=0;
        ArrayList<Node> childs;
        Node(int data){
            this.data=data;
            childs=new ArrayList<Node>();
        }
    }

    public static Node const(int[] arr){
        Stack<Node> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            int ele=arr[i];
            if(ele!=-1){
                st.push(new Node(ele));
            }
            else{
                Node node=st.pop();
                node.childs.add(node);
            }
        }
        return st.pop();
    }

    public static Node root2node(node,int data,ArrayList<node> list){
        if(node.data==data){
            list.add(node);
            return true;
        }

        boolean res= false;
        for(Node child : node.childs){
            res=res || root2node(child,data,list);
        }

        if(res) list.add(node);
        return res;
    }
}