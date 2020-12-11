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
    public static void display(Node node){
        StringBuilder sb=new StringBuilder();
        sb.append(node.data+" -> ");

        for(Node child:node.childs){
            sb.append(child.data);
        }

        System.out.println(sb);

        for(Node child:node.childs){
            display(child);
        }
    }
    public static int hieght(Node node){   // in terms of edge
        int h=-1;
        for(Node.child : node childs){
            h=Math.max(h,hieght(child));
        }
        return h+1; 
    }

    public static int size(Node node){
        int s=0;
        for(Node child: node.childs){
            s+=size(child);
        }

        return s+1;
    }

    public static boolean find(Node node,int data){
        if(node.data=data){
            return true;
        }
        for(Node child: node.childs){
            if(find(node,data)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] arr={10,20,50,-1,-1,60,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root=const(arr);
        display(root);

    }
}