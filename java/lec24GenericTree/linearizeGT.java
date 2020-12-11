import java.util.*;
class GTConst{
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
    public static Node linearize(Node node){
        if(node.childs.size()==0){
            return node;
        }
        int n=node.childs.size();
        Node gtail=linearize(node.childs.get(n-1));
        for(int i=n-2;i>=0;i--){
            Node tail=linearize(node.childs.get(i));

            tail.childs.add(node.childs.get(i+1));
            node.childs.remove(i+1);

        }

        return gtail;
    }
}