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