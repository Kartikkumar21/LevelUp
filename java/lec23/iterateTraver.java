public static class tPair{
        Node node = null;
        boolean selfdone=false;
        boolean leftdone=false;
        boolean rightdone=false;

        tPair(Node node,boolean selfdone,boolean leftdone,boolean right){
            this.selfdone = selfdone;
            this.leftdone = leftdone;
            this.right = rightdone;
        }
    }

    public static void IterTraversal(Node node){

        Stack<tPair> st = new Stack<>();
        st.push(new tPair(node,false,false,false));

        while(st.size()!=0){
            tPair rp = st.peek();
            
            if(!rp.selfdone){
                rp.selfdone = true;
                System.out.print(rp.node.data + " ");
            }else if(!rp.leftdone){
                rp.leftdone = true;
                if(rp.node.left != null) st.push(new tPair(rp.node.left,false,false,false));
            }else if(!rp.rightdone){
                rp.rightdone = true;
                if(rp.node.right != null) st.push(new tPair(rp.node.right,false,false,false));
            }else{
                st.pop();
            }
        }
    }